package homeworkBook.LastTeam;

import java.util.LinkedList;

public interface BoardFunctionInterface {
    public void createPost(LinkedList<String[]> postList);
    public void listPost(LinkedList<String[]> postList);
    public void detailPost(LinkedList<String[]> postList);
    public void correctionPost(LinkedList<String[]> postList);
    public void deletePost(LinkedList<String[]> postList);
    public void saveFilePost(LinkedList<String[]> postList);
    public void BoardInterface(String function);


}
