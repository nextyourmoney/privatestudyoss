package homeworkBook.LastTeam;

import java.util.LinkedList;
import java.util.Scanner;

public class DetailPostFunction extends BoardFunction{
    LinkedList<String[]> postList;
    Scanner scanner = new Scanner(System.in);
    boolean check = false;

    public DetailPostFunction(LinkedList<String[]> postList){

        this.postList = postList;
    }

    void detailpost(){
        System.out.print("조회 글 번호: ");
        String searchPostNumStr = scanner.nextLine();
        int searchPostNum = Integer.parseInt(searchPostNumStr);

        CheckPassword checkpassword = new CheckPassword();

        for(String[] postListArr : postList){
            if(postListArr[0].equals(searchPostNumStr)){
                check = true;
            }
        }

        if (check == false){
            System.out.println("없는 글 번호입니다. ");
            return;
        }

        String[] list  = postList.get(searchPostNum-1);
        System.out.printf("글번호: %s \t 내용: %s \t 작성자: %s \t 글 작성 시간: %s \t 글 비밀번호: %s \n",  list[0],  list[1],  list[2], list[3],  list[4]); //글번호, 내용, 작성자, 시간

    }

}
