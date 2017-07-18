package Controller;

import Domains.Category;
import service.CategoryService;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by anish on 7/18/17.
 */
@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String a = request.getParameter("id");
        if(page.equalsIgnoreCase("add")){
            RequestDispatcher rq = request.getRequestDispatcher("addcategory.jsp");
            rq.forward(request,response);
        }
        if(page.equalsIgnoreCase("store")){
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            try {
                int result = CategoryService.addCategory(name,description);
                if(result == 1){
                    System.out.println("Sucessfuly added!");
                    request.setAttribute("message","Category Sucessfully Added!");
                    RequestDispatcher rq = request.getRequestDispatcher("cat.jsp");
                    rq.forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(page.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(a);
            try {
                int result = CategoryService.deleteCategory(id);
                if(result == 1){
                    request.setAttribute("message","Sucessfully Deleted!");
                    RequestDispatcher rq = request.getRequestDispatcher("cat.jsp");
                    rq.forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(page.equalsIgnoreCase("edit")){
            int id = Integer.parseInt(a);
            try {
                Category cat = CategoryService.getCategory(id);
                request.setAttribute("cat",cat);
                RequestDispatcher rq = request.getRequestDispatcher("editCategory.jsp");
                rq.forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(page.equalsIgnoreCase("update")){
            int id = Integer.parseInt(a);
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            try {
                int result = CategoryService.updateCategory(id,name,description);
                if(result == 1){
                    request.setAttribute("message","Sucessfully Edited");
                    RequestDispatcher rq = request.getRequestDispatcher("cat.jsp");
                    rq.forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
