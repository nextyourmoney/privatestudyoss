package BoardProject_team.src.common.dto;

import lombok.*;

@Data
public class User {
	
	private String userId;
	private String userpassword;
	private String userNickName;
	private String userName;
	private int userAge;
	private String userPhoneNumber;
	private String userEmail;
	private int check;  //check가 1이면 아이디 없음 2이면 비밀번호가 일지하지 않음
}
