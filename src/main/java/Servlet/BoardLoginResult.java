package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardLoginResult extends HttpServlet {

    protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("euc-kr");
        Map<String,String> board=new HashMap<>();

        String title= request.getParameter("userID");
        String password=request.getParameter("userPassword");

        request.getRequestDispatcher("/WEB-INF/loginResult.jsp").forward(request, response);
    }
    public BoardLoginResult(){
        System.out.println("Servlet.BoardLoginResult Servlet 객체 생성");
    }


}
