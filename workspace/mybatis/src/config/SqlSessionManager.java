package config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionManager {
	public static SqlSessionFactory sqlSessionFactory;
	
	//정적 블록: 클래스가 메소드 영역으로 ㄷ로딩되면 자동으로 실행
	static {
		System.out.println("~~~~~~~");
		
		//(3월 23일) 아래의 sqlSessionFactory는 사용자가 생성및 관리한다.
		try {
			String resource = "config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource); //여기서 resourc는 org.apache.ibatis.io.resource에서 제공된다. //상대 경로로 파일 얻는다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//자바 객체와 sql을 매핑해서 DB 작업을 할 수 있도록 해주는 SqlSession객체 리턴
	//(3월 23일) 실제 코드에서 sql에서 사용하는 객체는 해당 객체이다.sqlSessionFactory에서 생성되는 sqlSession을 하는 것이 궁극적인 것이다.
	//반드시 AutoCloseable과 같은 것이 함께 구현되어 있어야 한다. 
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true); //autocommit 디폴트: false이다.  하지만 insert를 위해서는 true를 통해 commit해야 한다. 
		return sqlSession;
	}
	
	

}
