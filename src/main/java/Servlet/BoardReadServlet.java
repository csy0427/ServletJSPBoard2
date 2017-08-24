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

public class BoardReadServlet extends HttpServlet{
    private BoardManager boardManager= new BoardManager();
    private Map<String,String> board= null;

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("BoarWriteServlet constructor");
        super.init(servletConfig);
        board=new HashMap<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("BoardWriteServlet service method");

        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String views=request.getParameter("views");

        if ("".equals(title)) {
            title = "no title";
        }
        if ("".equals(views)) {
            views = "no views";
        }
        if ("".equals(content)) {
            content = "no content";
        }

        board.put("title",title);
        board.put("content",content);
        board.put("views",views);
        boardManager.addPost(board);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/write.jsp");
        dispatcher.forward(request,response);
    }
}
