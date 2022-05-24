package homeworkBook.LastTeam;

import java.util.LinkedList;
import java.util.Scanner;

public class CheckPassword {
    Scanner scanner = new Scanner(System.in);

    public boolean CheckPassword(int postNum, LinkedList<String[]> postList){
        boolean run = true;

        System.out.print("비밀번호 입력: ");
        String password = scanner.nextLine();

        if (password.equals(postList.get(postNum-1)[4])) { //입력한 비밀번호와 게시번호의 비밀번호랑 일치할때.
            System.out.println("비밀번호 성공!");
            return true;
        } else {
            System.out.println("비밀번호 실패!");
            return false;
        }
    }

}
