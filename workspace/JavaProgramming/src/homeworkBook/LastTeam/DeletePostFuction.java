package homeworkBook.LastTeam;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.LinkedList;
import java.util.Scanner;

public class DeletePostFuction extends BoardFunction{
    //필드
    LinkedList<String[]> postList;
    Scanner scanner = new Scanner(System.in);
    boolean check = false;

    //생성자
    public DeletePostFuction(LinkedList<String[]> postList){
        this.postList = postList;
    }

    //메소드
    void deletePost(){
        System.out.print("삭제 글 번호: ");
        String deletePostNumStr = scanner.nextLine();
        int deletePostNum = Integer.parseInt(deletePostNumStr);

        for(String[] postListArr : postList){
            if(postListArr[0].equals(deletePostNumStr)){
                check = true;
            }
        }

        if (check == false){
            System.out.println("없는 글 번호입니다. ");
            return;
        }

        CheckPassword checkpassword = new CheckPassword();

        if(checkpassword.CheckPassword(deletePostNum,postList)){ //ture가 나올 경우 실행
            System.out.println("삭제 완료. ");

            postList.remove(deletePostNum-1);
        }
    }
}
