package board_Project.common.Service;

import board_Project.common.dao.Userdao;
import board_Project.common.dto.User;


public class UserService {
	private Userdao userDao= new Userdao();
		
		
		//회원가입
		public void signUpBoard() {
			userDao.signUp();

		}
		//로그인
		public User loginBoard() {


			return userDao.login();
		}
		//로그아웃
		public void logout() {
			userDao.login(); //start창으로 가게 만들기
		
		}
}
