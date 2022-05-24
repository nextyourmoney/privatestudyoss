package BoardProject_team.src.common.Service;

import java.util.Scanner;

import common.dao.Userdao;
import common.dto.User;


public class UserService {
	private Userdao userDao= new Userdao();
		
		//시작화면
		public User start() {
			Scanner scanner = new Scanner(System.in);

			User user = null;
			UserService userService = new UserService();
			boolean loginCheck = true;

			while(loginCheck) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("1. 로그인     2. 회원가입");
				System.out.println("----------------------------------------------------------------------");
				System.out.print("선택: ");
				String select1 = scanner.nextLine();
				switch(select1){
				case "1":
					System.out.println("----------------------------------------------------------------------");
					System.out.println("로그인");
					System.out.println("----------------------------------------------------------------------");
					System.out.print("ID: ");
					String userId =  scanner.nextLine();
					System.out.print("Password: ");
					String userPassword =  scanner.nextLine();

					//로그인 메소드 호출 -> 리턴값이 1 : 로그인 성공 loginCheck=false while문 탈출
					user = userService.loginBoard(userId, userPassword);
					if(user.getCheck()==1) {
						System.out.println("존재하지 않는 아이디입니다.");

					}else if(user.getCheck()==2){
						System.out.println("비밀번호가 일치하지 않습니다.");

					}else {
						System.out.println(user.getUserNickName() + "님 로그인에 성공했습니다.");
						System.out.println("----------------------------------------------------------------------");
						loginCheck = false;					
					}
					break;
				case "2":
					//회원가입 메소드 호출
					System.out.println("----------------------------------------------------------------------");
					System.out.println("회원가입");
					System.out.println("----------------------------------------------------------------------");

					user=new User();
					String newUserId=null;
					String newUserPassword=null;
					String newUserNickname=null;
					String newUserName=null;
					int newUserAge = -1;
					String newUserPhonenumber=null;
					String newUserEmail=null;


					do {
						System.out.print("ID: ");
						newUserId = scanner.nextLine();	
					}while(newUserId.equals(""));

					do {
						System.out.print("Password: ");
						newUserPassword = scanner.nextLine();
					}while(newUserPassword.equals(""));

					do {
						System.out.print("Name: ");
						newUserName = scanner.nextLine();
					}while(newUserName.equals(""));
					
					do {
						System.out.print("Nickname: ");
						newUserNickname = scanner.nextLine();
					}while(newUserNickname.equals(""));

					do {
						System.out.print("Age: ");
						try {
							newUserAge = Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {
							System.out.println("값을 숫자로만 입력해 주세요.");
						}
					}while(newUserAge==-1);
					
					do {
						System.out.print("Phonenumber: ");
						try {
							newUserPhonenumber = scanner.nextLine();
						}catch(NumberFormatException e) {
							System.out.println("값을 숫자로만 입력해 주세요.");
						}
					}while(newUserPhonenumber.equals(""));
					
					do {
						System.out.print("Email: ");
						newUserEmail = scanner.nextLine();
					}while(newUserEmail.equals(""));
		
					user.setUserId(newUserId);
					user.setUserpassword(newUserPassword);
					user.setUserName(newUserName);
					user.setUserNickName(newUserNickname);
					user.setUserAge(newUserAge);
					user.setUserPhoneNumber(newUserPhonenumber);
					user.setUserEmail(newUserEmail);
					
					int result = userService.signUpBoard(user);
					if(result==-1) {
						System.out.println("이미 존재하는 아이디입니다.");
					}else if(result==-2){
						System.out.println("이미 존재하는 닉네임입니다.");					
					}else if (result==-3){
						System.out.println("이미 존재하는 아이디와 닉네임입니다.");					
					}else {
						System.out.println("회원가입 완료");					
					}
					break;
				default:
					System.out.println("올바른 값을 입력하세요.");
					break;
				}
			}
			return user;
		}
		
		//회원가입
		public int signUpBoard(User user) {
			return userDao.signUp(user);
		}
		//로그인
		public User loginBoard(String userId, String userPassword) {
			return userDao.login(userId, userPassword);
		}
		//로그아웃
		public void logout() {
			start();
		}
}
