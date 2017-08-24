package Servlet;

import Manager.BoardManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardReadListServlet extends HttpServlet{

    private BoardManager boardManager= new BoardManager();
    private Map<String,Map<String,String>> returnBoardList=null;

    public void init(ServletConfig servletConfig) throws ServletException{
        System.out.println("BoardReadListServlet constructor");
        super.init(servletConfig);
        //System.out.println((BoardManager)servletConfig.getServletContext().getAttribute("boardManger"));
        //boardManager=(BoardManager)servletConfig.getServletContext().getAttribute("boardManger");
        returnBoardList=new HashMap<>();
    }
    protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        System.out.println("BoardReadListServlet service method");
        try {
            returnBoardList = boardManager.getList();
        }
        catch(NullPointerException e){
            System.out.println("NULL");
        }
        request.setAttribute("totalList",returnBoardList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/list.jsp");
        dispatcher.forward(request,response);
    }
}
