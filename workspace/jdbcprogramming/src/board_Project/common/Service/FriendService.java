package board_Project.common.Service;

import board_Project.common.dao.FriendDao;

public class FriendService {
	private FriendDao friendDao= new FriendDao();
	//친구 추가
	public  void addFriend(String name) {
		friendDao.add();
		
	}
	//친구 목록 보기
	public void showFriendList(String id) {
		
	}
	//친구 삭제
	public void deleteFriend(String name) {
		
	}
	//친구 게시물 보기
	public void showFriendBoard(String name) {
		
	}

}
