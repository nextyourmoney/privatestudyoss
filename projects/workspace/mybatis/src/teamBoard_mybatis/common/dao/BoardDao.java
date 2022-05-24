package teamBoard_mybatis.common.dao;

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

import org.apache.ibatis.annotations.Mapper;

import teamBoard_mybatis.common.ConnectionManager;
import teamBoard_mybatis.common.dto.Board;


@Mapper
public interface BoardDao {
	
	
	//게시글 작성
	public int write(Board board);

	public int selectTotalRowCount();
	
	public List<Board> selectBoardwithUser();
	
	public List<Board> selectBoardwithUser2(int num2);
	
	public List<Board> selectByname(String name);
	
	public List<Board> selectBytitle(String title);
	
	public Board selectBoard(int bno);
	
	public int updateBoard(Board board);
	
	public int deleteBoard(int bno);

	
	
}
