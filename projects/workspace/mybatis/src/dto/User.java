package dto;

import java.util.List;

import lombok.*;

@Data
public class User {
	
	private String userId;
	private String userPassword;
	private String userNickName;
	private String userName;
	private int userAge;
	private String userPhoneNumber;
	private String userEmail;
	
	private List<Board> boards;

}
