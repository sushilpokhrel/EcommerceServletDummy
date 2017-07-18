package Controller;

import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by anish on 7/18/17.
 */
@WebServlet(name = "AdminNavigationServlet")
public class AdminNavigationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("home")){
            RequestDispatcher rq = request.getRequestDispatcher("admin.jsp");
            rq.forward(request,response);
        }else if(page.equalsIgnoreCase("cat")){
            try {
                request.setAttribute("catList", CategoryService.getCatList());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("cat.jsp");
            requestDispatcher.forward(request,response);
        }else if(page.equalsIgnoreCase("prod")){
            try {
                request.setAttribute("catList", ProductService.getprodList());
                RequestDispatcher rq = request.getRequestDispatcher("prod.jsp");

                rq.forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            RequestDispatcher rq = request.getRequestDispatcher("404.jsp");
            rq.forward(request,response);
        }
    }
}
