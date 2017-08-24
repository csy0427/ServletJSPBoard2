package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardLoginServlet extends HttpServlet{
    /*@Override
    protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("euc-kr");
        String id=request.getParameter("id");
    }*/
    public BoardLoginServlet(){
        System.out.println("BoardLogin Servlet 객체 생성");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("doGet 메소드 호출");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request,response);
        response.sendRedirect("/login.do");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        System.out.println("doPost 메소드 호출");
        request.setCharacterEncoding("euc-kr");
        String id=request.getParameter("userID");
        String password=request.getParameter("userPassword");
        response.setContentType("text/html;charset=euc-kr");
        request.setAttribute("id",id);
        request.setAttribute("password",password);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/loginResult.jsp");
        dispatcher.forward(request,response);
    }
}
