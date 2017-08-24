package Servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardWriteFormServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("doGet 메소드 호출");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
        dispatcher.forward(request,response);
        response.sendRedirect("/write");
    }

}
