package example.exam01_get_sqlsession;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;

public class GetSqlSessionExample01 {

	public static void main(String[] args) {
		
		/*
		//sqlSession 객체를 선언하는 방법 #1
		SqlSession sqlSession = SqlSessionManager.getSqlSession();
		System.out.println("SqlSession 객체 생성 성공");
		sqlSession.close(); //close를 통해 메모리를 절약한다. 
		*/
		
		/*
	 	//sqlSession 객체를 선언하는 방법 #2
		SqlSession sqlSession = null;
		try{
			SqlSession sqlSession = SqlSessionManager.getSqlSession();
			System.out.println("SqlSession 객체 생성 성공");
			//..... 작성 코드
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		*/
		
		//(3월 23일) 자동 리소스 활성 및 리소스 close 위의 두가지 코드와 같은 방식이다. 
		//단 try에 사용되는 sqlSession 객체는 autocloseable, closeable과 같은 것이 함께 구현되어 있어야 한다. 
		try(SqlSession sqlSession = SqlSessionManager.getSqlSession()){
			
			System.out.println("SqlSession 객체 생성 성공");
			//..... 작성 코드
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

}
