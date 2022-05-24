package homeworkBook.LastTeam;

import java.util.LinkedList;
import java.util.Scanner;

public class  BoardFunction implements BoardFunctionInterface {

    int postNum = 0;

    @Override
    public void createPost(LinkedList<String[]> postList) { //게시글 작성
        postNum += 1;
        CreatePostFunction create = new CreatePostFunction(postNum, postList); //게시글 작성 객체 생성 //링크드 리스트
        BoardInterface("글 작성"); //글작성 UI출력
        create.createPost(); //게시글 작성
    }

    @Override
    public void listPost(LinkedList<String[]> postList) { //작성글 목록 보기 //역정렬(내림차순)
        ListPostFunction list = new ListPostFunction(postList);
        BoardInterface("내용 출력"); //글작성 UI출력
        list.listPost(); //게시글 작성

    }

    @Override
    public void detailPost(LinkedList<String[]> postList) {
        DetailPostFunction detail = new DetailPostFunction(postList);
        BoardInterface("조회"); //글작성 UI출력
        detail.detailpost(); //게시글 작성

    }

    @Override
    public void correctionPost(LinkedList<String[]> postList) { // 수정하기 //비밀번호가 있을 시 비밀번호 입력해야 수정 할 수있다.  또한 비밀번호포함여 전부 수정가능
        CorrectionPostFunction correction = new CorrectionPostFunction(postList);
        BoardInterface("수정"); //글작성 UI출력
        correction.correctionPost(); //게시글 작성
    }

    @Override
    public void deletePost(LinkedList<String[]> postList) {
        DeletePostFuction delete = new DeletePostFuction(postList);
        BoardInterface("삭제"); //글작성 UI출력
        delete.deletePost();
        //게시글 작성

    }

    @Override
    public void saveFilePost(LinkedList<String[]> postList) {
        SaveFileFunction saveFile = new SaveFileFunction(postList);
        BoardInterface("파일저장"); //글작성 UI출력
        saveFile.saveFile(); //게시글 작성

    }

    @Override
    public void BoardInterface(String function) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("\t\t\t\t\t\t\t\t   %S \t\t\n", function);
        System.out.println("---------------------------------------------------------------------------------");

    }


}
