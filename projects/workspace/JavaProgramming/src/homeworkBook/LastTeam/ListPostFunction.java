package homeworkBook.LastTeam;

import java.text.SimpleDateFormat;
import java.util.*;

public class ListPostFunction extends BoardFunction{
    LinkedList<String[]> postList;

    //생성자
    public ListPostFunction(LinkedList<String[]> postList){
        this.postList = postList;
    }

    void listPost(){
        Collections.reverse(postList); //역정렬
        for(String[] postListArr : postList) { //for문을 통한 전체출력
            System.out.printf("%s \t %s \t %s \t %s \n", postListArr[0], postListArr[1], postListArr[2], postListArr[3]); //글번호, 내용, 작성자, 시간
        }
        Collections.reverse(postList); //재정렬
    }
}
