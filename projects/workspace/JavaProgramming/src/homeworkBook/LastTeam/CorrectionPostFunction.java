package homeworkBook.LastTeam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class CorrectionPostFunction extends BoardFunction{
    LinkedList<String[]> postList;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date createTimeCheck = new Date();
    String[] postStrArr;
    boolean run = true;
    boolean check = false;

    public CorrectionPostFunction(LinkedList<String[]> postList){

        this.postList = postList;
    }

    void correctionPost(){
        System.out.print("수정 글 번호: ");
        String correctionPostNumStr = scanner.nextLine();
        int correctionPostNum = Integer.parseInt(correctionPostNumStr);

        CheckPassword checkpassword = new CheckPassword();

        for(String[] postListArr : postList){
            if(postListArr[0].equals(correctionPostNumStr)){
                check = true;
            }
        }

        if (check == false){
            System.out.println("없는 글 번호입니다. ");
            return;
        }

        if(checkpassword.CheckPassword(correctionPostNum,postList)){ //ture가 나올 경우 실행
            while(run){
                //글번호, 내용, 작성자, 시간, 비밀번호
                //내용, 작성자, 비밀번호 변경 가능하도록한다. //시간은 자동 수정
                System.out.print("내용 수정: ");
                String correctionPostContents = scanner.nextLine().trim();
                System.out.print("작성자 수정: ");
                String correctionPostWriter = scanner.nextLine().trim();
                System.out.print("비밀번호 수정: ");
                String correctionPassword = scanner.nextLine().trim();
                String correctionTime = format1.format(createTimeCheck); //수정 시간 저장

                //글 번호, 내용, 작성자, , 시간 ,비밀번호
                postStrArr = new String[]{correctionPostNumStr, correctionPostContents, correctionPostWriter, correctionTime, correctionPassword, }; //입력 값을 배열로 생성

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
            postList.set(correctionPostNum - 1, postStrArr);
        }
    }
}
