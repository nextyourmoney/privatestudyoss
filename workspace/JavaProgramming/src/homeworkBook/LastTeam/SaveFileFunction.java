package homeworkBook.LastTeam;


import java.io.FileWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedList;


public class SaveFileFunction extends BoardFunction{
    LinkedList<String[]> postList;

    public SaveFileFunction(LinkedList<String[]> postList){

        this.postList = postList;
    }

    void saveFile(){

        try {
           Writer writer = new FileWriter("./saveFile.txt");

            for(String[] postListArr : postList) { //for문을 통한 전체출력
                String postList = Arrays.toString(postListArr);
                writer.write(postList);

                writer.flush();
                writer.close();
                System.out.println("파일 저장 완료");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
