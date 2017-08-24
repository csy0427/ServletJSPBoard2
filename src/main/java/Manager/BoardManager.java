package Manager;

import DB.BoardDatabase;

import java.util.HashMap;
import java.util.Map;

public class BoardManager {
    BoardDatabase boardDatabase=new BoardDatabase();

    public Map<String,Map<String,String>> getList() {
        int numOfPost=boardDatabase.getNumOfPost();
        Map<String,Map<String,String>> tmpList=new HashMap<>();
        if(numOfPost<=0) { System.out.println("NULLz"); return null;}
        for(int i=0;i<numOfPost;i++){
            String boardNumber=boardDatabase.getBoardNumber().get(i);
            if(boardDatabase.readPost(boardNumber)!=null){
                Map<String,String> tmpMap=boardDatabase.readPost(boardNumber);
                tmpList.put(boardNumber,tmpMap);
            }
        }
        return tmpList;
    }

    public void addPost(Map<String, String> board) {
        boardDatabase.addPost(board);
    }
}
