package Controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created by anish on 7/18/17.
 */
@javax.servlet.annotation.WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("admin.jsp");
        rq.forward(request,response);
    }
}
