package common.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.ConnectionManager;
import common.dto.Board;
import common.paging.Pager;

public class BoardDao {
	private Pager pager;
	
	//리스트 목록 출력 - 리스트 보기
	//bno로 받은 번호의 게시판을 출력한다.
	
		
	//검색 //닉네임 검사, 제목검사로 구분해야한다.
	public List<Board> SearchByList(String searchNum) {
		//BoardService에서 가져온 searchNum이 1이면 닉네임 검사, 2이면 제목검사를 시행한다.
		Connection conn=null;
		pager = new Pager(10, 5, getTotalRows(), 1); //페이지 분할 
		List<Board> list=new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String searchContent = null;
		String sql = null;
		
		try {
			//연결
			conn=ConnectionManager.getConnection2();
			
			switch(searchNum) {
			
				case "1": //닉네임 검색
					sql = new StringBuilder()
						.append("select rnum, btitle, bwriter, bdate")
						.append(" from ( ")
						.append(" select rownum as rnum ,btitle, bwriter, bdate")
						.append("  from (")
						.append(" select btitle, bwriter, bdate")
						.append(" from boards, users where usernickname = ? ")
						.append(" order by bno desc")
						.append("  ) ")
						.append(" where rownum <= ?")
						.append(" ) ")
						.append("where rnum >= ?").toString();
					
					System.out.print("닉네임으로 게시글 검색: ");
					searchContent = scanner.nextLine();
					
					break;
					
				case "2": //제목 검색
					sql = new StringBuilder()
						.append("select rnum, btitle, bwriter, bdate")
						.append(" from ( ")
						.append(" select rownum as rnum ,btitle, bwriter, bdate")
						.append("  from (")
						.append(" select btitle, bwriter, bdate")
						.append(" from boards where btitle= ? ")
						.append(" order by bno desc")
						.append("  ) ")
						.append(" where rownum <= ?")
						.append(" ) ")
						.append("where rnum >= ?").toString();
					
					System.out.print("제목으로 게시글 검색: ");
					searchContent = scanner.nextLine();	
					break;
			}
			
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, searchContent);
			pstm.setInt(2, pager.getPageNo()*pager.getRowsPerPage());
			pstm.setInt(3, (pager.getPageNo()-1)*pager.getRowsPerPage()+1);
			
			//실행해서 결과셋얻기
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Board board=new Board();
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				list.add(board);
				
			}
			
			rs.close();
			pstm.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try 
			{conn.close();}catch(Exception e) {}
		}
		
	
	return list;
		
		
		
	}
	
	//게시글 작성
	public int write(String nickname) { //현재 로그인한 사용자의 아이디 비밀번호 값을 가져와야 한다. 합칠때 작업해야 할 
		
		int rows = 0; //성공여부 확인을 위한 정수
		Scanner scanner = new Scanner(System.in);
		
		Board board = new Board();
		System.out.print("글 제목: "); board.setBtitle(scanner.nextLine());
		System.out.print("내용: "); board.setBcontent(scanner.nextLine());
		System.out.print("첨부 파일 경로: "); board.setBfilepath(scanner.nextLine());
		System.out.println("[1. 전체보기.  2.자유게시판.    3.질문게시판.    4.학업게시판] ");
		System.out.print("게시판 카테고리: "); board.setBcategoryid(scanner.nextInt());
		
		Connection conn = null;
		//boolean run =false;
		try {
				//연결
				conn = ConnectionManager.getConnection2();
				
				String sqlWriter = "select usernickname from users where userid = ?";
				PreparedStatement pstmWriter = conn.prepareStatement(sqlWriter); //작성자를 가져오기 위해 user테이블의 닉테임 컬럼값을 가져온다.
				pstmWriter.setString(1, nickname); //동작 테스트를 위하여 하드 코딩 진행 //수정 예정
				
				ResultSet rs = pstmWriter.executeQuery();
		         
		        if(rs.next()) {
		        	//run=true;
		        	board.setBwriter(rs.getString("usernickname"));
		   
		         }else {
		        	 rows=-1;
		         }
		      //  if(run==true) {
				
				String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata, bcategoryid)"
						+ " values(seq_boards_bno.nextval, ?, ?, ?, sysdate, ?, ?, ?)";

				PreparedStatement pstm = conn.prepareStatement(sql);				
				
				pstm.setString(1, board.getBtitle());
				pstm.setString(2, board.getBcontent());
				pstm.setString(3, board.getBwriter()); //현재 로그인한 아이디의 닉네임이 작성자로 자동으로 들어간다. ///수정예정
				pstm.setInt(6, board.getBcategoryid());
				
				if(!board.getBfilepath().equals("")) {
					File file = new File(board.getBfilepath());
					pstm.setString(4, file.getName());
					pstm.setBlob(5, new FileInputStream(board.getBfilepath()));
					
				} else {
					pstm.setString(4,  null);
					Blob blob = null;
					pstm.setBlob(5,  blob);
				}
				
				rows = pstm.executeUpdate(); //insert into가 되면 1이 반환된다.
				
				pstm.close();
				pstmWriter.close();
		        rs.close();

		     //}
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				try 
				{conn.close();}catch(Exception e) {}
			}
			
		return rows;
	}
	
	//상세보
	
	//수정 - 게시물 수정
	
	public int update(String selectUpdatestr) {

		int selectUpdate =Integer.parseInt(selectUpdatestr);
		Scanner scanner = new Scanner(System.in);
		int rows = 0;
		
		Connection conn=null;
		
		Board board = new Board();
		System.out.print("수정 글 제목: "); board.setBtitle(scanner.nextLine());
		System.out.print("수정 내용: "); board.setBcontent(scanner.nextLine());
		System.out.print("수정 첨부 파일 경로: "); board.setBfilename(scanner.nextLine());
		System.out.println("[1. 전체보기.  2.자유게시판.    3.질문게시판.    4.학업게시판] ");
		System.out.print("수정 게시판 카테고리: "); board.setBcategoryid(Integer.parseInt(scanner.nextLine()));
		
		try {
			//연결
			conn = ConnectionManager.getConnection2();

			String sql = "update boards set btitle = ?, bcontent = ?, bcategoryid = ?";
			sql += (board.getBfilename().equals("") ? ", bfilename = ? , bfiledata = ? " : "");
			sql += " where bno = ?";
			System.out.println(sql);
			
			//sql실행 state얻기
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, board.getBtitle());
			pstm.setString(2, board.getBcontent());
			pstm.setInt(3, board.getBcategoryid());
			
			
			if(board.getBfilename() != null) {
				System.out.println(sql);
				File file=new File(board.getBfilename());
				pstm.setString(4, file.getName());
				pstm.setBlob(5, new FileInputStream(file));
				pstm.setInt(6, selectUpdate);
			} else {
			pstm.setInt(4, selectUpdate);
			}
			System.out.println(sql);
			
			//실행해서 결과셋얻기
			rows = pstm.executeUpdate(); 
			pstm.close();
			//연결해제
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try 
			{conn.close();}catch(Exception e) {}
		}
		
		return rows;
	
	}
	
	
	
	
	public int count() {
		int result =0;
		Connection conn=null;
		List<Board> list=new ArrayList<>();
		try {
				//연결
				conn=ConnectionManager.getConnection();
				String sq2="select count(*) as totalRows from boards";
				PreparedStatement pstm=conn.prepareStatement(sq2);
				//실행해서 결과셋얻기
				ResultSet rs=pstm.executeQuery();
				if(rs.next()) {
					result=rs.getInt("totalRows");
					
				}
				
				rs.close();
				pstm.close();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		
		return result;
	}
	
	//삭제
	public int deleteByBno(int bno) {
		int result =0;
		Connection conn=null;
		
		try {
				//연결대여
				conn=ConnectionManager.getConnection2();
				String sq2 = "delete from boards where bno = ?";
				PreparedStatement pstm=conn.prepareStatement(sq2);
				pstm.setInt(1, bno);
				
				//실행해서 결과셋얻기
				result = pstm.executeUpdate();				
				pstm.close();
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try //연결반납
				{conn.close();}catch(SQLException e) {}
			}
		
		return result;
	}
	

	//상세보
	public List<Board> detailByBno(int bno) {

		Board board=null;
		Connection conn=null;
		List<Board> list=new ArrayList<>();
		
		try {
			//연결
			conn=ConnectionManager.getConnection2();
			
			String sql="select bno, btitle, bwriter, bdate, bcontent, bfilename, bcategoryid from boards where bno = ?";
			
			//sql실행 state얻기
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bno); //bno인데 실제 값은 bcategoryid이다.
		
			//실행해서 결과셋얻기
			ResultSet rs=pstm.executeQuery();
			
			//행값 읽기
			if(rs.next()) {
				board =new Board();
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBcategoryid(rs.getInt("bcategoryid"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBno(rs.getInt("bno"));
				list.add(board);
				
			}
			
			rs.close();
			pstm.close();
			//연결해제
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		
		return list;
	}
	
	
	private int getTotalRows() { //전체 페이지(전체열 구하기)
		int result = 0;
		
		 Connection conn = null;
	      
	      try {
	         conn = ConnectionManager.getConnection2();
	         
	         String sql = "select count(*) from boards"; //전체 개수 
	        		 
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 result = rs.getInt(1);
	         }
	         
	         rs.close();
	         pstmt.close();
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         try { 
	        	 conn.close(); 
	        } catch (SQLException e) {}
	      }
		return result;
	}

	
}
