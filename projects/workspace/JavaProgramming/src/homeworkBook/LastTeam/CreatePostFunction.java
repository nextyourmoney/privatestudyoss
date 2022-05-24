package homeworkBook.LastTeam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class CreatePostFunction extends BoardFunction{
    //1번 선택시 글을 작성한다.
    //글 번호, 내용, 작성자, 비밀번호(0000 입력시 비밀 번호 없음), 시간
    //이때 글번호, 시간은 보이지는 않으며 저장만 된다.
    Scanner scanner = new Scanner(System.in);

    //필드
    LinkedList<String[]> postList;
    int postNum;
    String[] postStrArr;
    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date createTimeCheck = new Date();
    boolean run = true;

    //생성자
    public CreatePostFunction(int postNum,LinkedList<String[]> postList){
        this.postList = postList;
        this.postNum = postNum;


    }

    //메소드
    void createPost(){
        String postNumstr = Integer.toString(postNum); //첫 시작시 0으로 시작하므로 1부터 시작하기 위해

        while(run) {
            System.out.print("내용: ");
            String postStrContents = scanner.nextLine().trim();//내용 입력
            System.out.print("작성자: ");
            String postStrWriter = scanner.nextLine().trim();//작성자 입력
            System.out.print("비밀번호: ");
            String postStrPassword = scanner.nextLine().trim();//비밀번호 입력
            String createTime = format1.format(createTimeCheck);

            //글 번호, 내용, 작성자, , 시간 ,비밀번호(0000 입력시 비밀 번호 없음)
            postStrArr = new String[]{postNumstr,postStrContents, postStrWriter, createTime, postStrPassword, }; //입력 값을 배열로 생성

            for (String strCheck : postStrArr){
                if(strCheck.equals("")){ //입력을 빈칸으로 입력했을 때
                    System.out.println("양식이 틀렸습니다. 다시 입력하세요");
                    run = true;
                    break;
                } else{
                    run = false;
                }
            }

        }

        postList.add(postStrArr); //입력 값들에 이상이 없을 경우 링크드 리스트에 배열을 입력한다

    }

}
