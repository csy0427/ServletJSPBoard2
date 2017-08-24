package DB;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDatabase {

    private static final String boardPath="board.txt";
    private static final String indexPath="index.txt";
    File file=new File(boardPath);

    public BoardDatabase(){

       file=new File(boardPath);
        if(!file.exists()){
            System.out.println("no boardfile");
        }
        file=new File(indexPath);
        if(!file.exists()){
            System.out.println("no indexfile");
        }
    }
    public List<String> getBoardNumber(){
        file=new File(indexPath);
        if(!file.exists()){
            System.out.println("no file");
        }
        List<String> tmpList=new ArrayList<>();
        try {
            InputStream stream=this.getClass().getResourceAsStream("/index.txt");
            InputStreamReader inputStreamReaderReader=new InputStreamReader(stream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReaderReader);
            String boardNumber="";
            while((boardNumber=bufferedReader.readLine())!=null){
                tmpList.add(boardNumber);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpList;
    }
    public int getNumOfPost() {
        return getBoardNumber().size();
    }

    public Map<String,String> readPost(String boardNumber) {
        file=new File(boardPath);
        Map<String,String> tmpMap=new HashMap<>();
        try {
            InputStream stream=this.getClass().getResourceAsStream("/board.txt");
            InputStreamReader inputStreamReaderReader=new InputStreamReader(stream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReaderReader);
            String tmp="";
            while((tmp=bufferedReader.readLine())!=null){
                String[] args=tmp.split("/");
                if(args[0].equals(boardNumber)){
                    tmpMap.put("title",args[1]);
                    tmpMap.put("content",args[2]);
                    tmpMap.put("views",String.valueOf(Integer.parseInt(args[3])+1));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpMap;
    }

    public void addPost(Map<String, String> board) {
        int currentBoardNumber=getNumOfPost()+1;
        file=new File(boardPath);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("board.txt",true));
            BufferedWriter bufferedWriter1=new BufferedWriter(new FileWriter("index.txt",true));

            bufferedWriter.write(String.valueOf(currentBoardNumber));
            bufferedWriter.write("/");
            bufferedWriter.write(board.get("title"));
            bufferedWriter.write("/");
            bufferedWriter.write(board.get("content"));
            bufferedWriter.write("\n");

            bufferedWriter.write(String.valueOf(currentBoardNumber));
            bufferedWriter.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
