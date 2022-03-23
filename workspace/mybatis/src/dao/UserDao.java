package dao;

import org.apache.ibatis.annotations.Mapper;

//인터페이스로 생성하여 maaper의 user.xml과 1대1로 맵핑한다. 
//해당 인터페이스를 통해 sql을 연결 및 활용한다
//마이바티스에서 인터페이스를 구현한 클래스를 생성한다. //해당 인터페이스는 마이바티스가 관리한다.


@Mapper //마이바티스에서 관리하는 맵퍼라는 것을 선언한다.
public interface UserDao {

}
