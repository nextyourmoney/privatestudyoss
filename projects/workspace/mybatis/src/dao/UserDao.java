package dao;

import org.apache.ibatis.annotations.Mapper;

import dto.User;

//인터페이스로 생성하여 maaper의 user.xml과 1대1로 맵핑한다. 
//해당 인터페이스를 통해 sql을 연결 및 활용한다
//마이바티스에서 인터페이스를 구현한 클래스를 생성한다. //해당 인터페이스는 마이바티스가 관리한다.
//해당 DAO에 선언되는 값들은 전부 자바에서만 사용되는 것들이다. 
//xml에서 선언될떄 해당 경로로 연결이 되어있고 해당 파일에는 없어도 사용 가능하다.

@Mapper //마이바티스에서 관리하는 맵퍼라는 것을 선언한다.
public interface UserDao {
	public User selectUser(String userid);
	public User selectUserwithBoards(String userid);
	public int insertUser(User user);
	

}
