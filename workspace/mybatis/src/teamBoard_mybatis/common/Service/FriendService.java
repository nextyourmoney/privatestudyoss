package teamBoard_mybatis.common.Service;

import java.util.List;
import java.util.Scanner;

import teamBoard_mybatis.common.dao.FriendDao;
import teamBoard_mybatis.common.dto.Board;
import teamBoard_mybatis.common.dto.User;
import teamBoard_mybatis.common.paging.Pager;

public class FriendService {
	private FriendDao friendDao= new FriendDao();
	String keyid;
	Scanner scanner;

	public FriendService(String keyid) {
		this.keyid=keyid;
		scanner=new Scanner(System.in);


	}
	
	//친구 추가
	public  void addFriend(String name) {
		friendDao.add(keyid,name);
		

	}
	//친구 목록 보기
	public void showFriendList(Pager pager) {

		boolean run=true;

		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("NickName\tName\tAge\tPhonenumber\tEmail");
			System.out.println("-----------------------------------------------");
			System.out.println(". . .");
			List<User> list = friendDao.showList(keyid,pager);
			for(User u: list) {
				System.out.print(u.getUserNickName()+"\t\t");
				System.out.print(u.getUserName()+"\t\t");
				System.out.print(u.getUserAge()+"\t\t");
				System.out.print(u.getUserPhoneNumber()+"\t\t");
				System.out.println(u.getUserEmail()+"\t\t");

			}
			System.out.println("-----------------------------------------------");
			System.out.print((pager.getPageNo()==1)?"":" [First]");
			System.out.print((pager.getGroupNo()>=2)?" [Prev] ":"");
			for(int i=pager.getStartPageNo();i<=pager.getEndPageNo();i++) {
				if(i==pager.getPageNo()) {
					System.out.print("("+i+")"+((i!=pager.getEndPageNo())?", ":""));
				}else {
					System.out.print(i+((i!=pager.getEndPageNo())?", ":""));
				}

			}
			System.out.print((pager.getPageNo()==pager.getEndPageNo())?"":" [Next]");
			System.out.println((pager.getGroupNo()<pager.getTotalGroupNo())?" [Last] ":"");
			System.out.print("선택 : ");
			String select=scanner.nextLine();
			try {
				if(select.equals("종료"))run=false;
				if(select.equals("f") || select.equals("F")) {
					if(pager.getPageNo()==1)continue;
					pager=getFirstPage(pager);
				}else if(select.equals("p") || select.equals("P")) {
					pager=getPrevGroup(pager);
				}else if(select.equals("n") || select.equals("N")) {
					if(pager.getGroupNo()==pager.getTotalGroupNo())continue;
					pager=getNextGroup(pager);
				}else if(select.equals("l") || select.equals("L")) {
					if(list.size()==0)continue;
					pager=getLast(pager);
				}else {
					if(Integer.parseInt(select)>pager.getTotalPageNo())continue;
					pager=getPage(Integer.parseInt(select),pager);
				}
			}catch(Exception e) {
				System.out.println("재실행");
			}

		}

	}

	//친구 삭제
	public void deleteFriend(String name) {

		friendDao.delete(keyid,name);
		
	}
	//친구 게시물 보기
	public void showFriendBoard(Pager pager) {
		boolean run=true;
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("NickName\tName\tAge\tPhonenumber\tEmail");
			System.out.println("-----------------------------------------------");
			System.out.println(". . .");
			List<Board> list = friendDao.showBoard(keyid,pager);
			for(Board b: list) {
				System.out.print(b.getBtitle()+"\t\t");
				System.out.print(b.getBwriter()+"\t\t");
				System.out.println(b.getBdate()+"\t\t");

			}
			System.out.println("-----------------------------------------------");
			System.out.print((pager.getPageNo()==1)?"":" [First]");
			System.out.print((pager.getGroupNo()>=2)?" [Prev] ":"");
			for(int i=pager.getStartPageNo();i<=pager.getEndPageNo();i++) {
				if(i==pager.getPageNo()) {
					System.out.print("("+i+")"+((i!=pager.getEndPageNo())?", ":""));
				}else {
					System.out.print(i+((i!=pager.getEndPageNo())?", ":""));
				}

			}
			System.out.print((pager.getPageNo()==pager.getEndPageNo())?"":" [Next]");
			System.out.println((pager.getGroupNo()<pager.getTotalGroupNo())?" [Last] ":"");
			System.out.print("선택 : ");
			String select=scanner.nextLine();
			try {
				if(select.equals("종료"))run=false;
				if(select.equals("f") || select.equals("F")) {
					if(pager.getPageNo()==1)continue;
					pager=getFirstPage(pager);
				}else if(select.equals("p") || select.equals("P")) {
					pager=getPrevGroup(pager);
				}else if(select.equals("n") || select.equals("N")) {
					if(pager.getGroupNo()==pager.getTotalGroupNo())continue;
					pager=getNextGroup(pager);
				}else if(select.equals("l") || select.equals("L")) {
					if(list.size()==0)continue;
					pager=getLast(pager);
				}else {
					if(Integer.parseInt(select)>pager.getTotalPageNo())continue;
					pager=getPage(Integer.parseInt(select),pager);
				}
			}catch(Exception e) {
				System.out.println("재실행");
			}

		}


	}
	public int getTotalFriendNum() {
		return friendDao.countFriend(keyid);
	}
	public int getTotalFBoardNum() {

		return friendDao.countBoard(keyid);
	}
	private Pager getFirstPage(Pager pager) {

		return pager = new Pager(10,5,pager.getTotalRows(),1);

	}
	private Pager getPrevGroup(Pager pager) {
		return pager=new Pager(10,5,pager.getTotalRows(),pager.getStartPageNo());
	}
	private Pager getPage(int parseInt,Pager pager) {

		return pager=new Pager(10,5,pager.getTotalRows(),parseInt);

	}
	private Pager getNextGroup(Pager pager) {

		return pager=new Pager(10,5,pager.getTotalRows(),pager.getEndPageNo()+1);
	}
	private Pager getLast(Pager pager) {
		return pager = new Pager(10,5,pager.getTotalRows(),pager.getTotalPageNo());
	}



}
