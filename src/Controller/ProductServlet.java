package Controller;

import Domains.Category;
import Domains.Products;
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
import java.util.List;

import static service.CategoryService.*;
import static service.CategoryService.addCategory;

/**
 * Created by anish on 7/18/17.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        System.out.println(page);
        String a = request.getParameter("id");
        if(page.equalsIgnoreCase("add")){
            try {
                request.setAttribute("catList", CategoryService.getCatList());
                RequestDispatcher rq = request.getRequestDispatcher("addProduct.jsp");
                rq.forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(page.equalsIgnoreCase("store")){
            System.out.println("here");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Double price = Double.parseDouble(request.getParameter("price"));
            int cat_id = Integer.parseInt(request.getParameter("cat_id"));
            try {
                int result = ProductService.addProduct(name,description,quantity,price,cat_id);
                if(result == 1){
                    request.setAttribute("message","Product Added Sucessfully");
                    RequestDispatcher rq = request.getRequestDispatcher("prod.jsp");
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
                int result = ProductService.delete(id);
                if(result == 1){
                    request.setAttribute("message","Deleted Sucessfully");
                    RequestDispatcher rq = request.getRequestDispatcher("prod.jsp");
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
                request.setAttribute("catList", CategoryService.getCatList());
                request.setAttribute("prod", ProductService.getProdbyId(id));
                RequestDispatcher rq = request.getRequestDispatcher("editprod.jsp");
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
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Double price = Double.parseDouble(request.getParameter("price"));
            int cat_id = Integer.parseInt(request.getParameter("cat_id"));
            try {
                int result = ProductService.updateProduct(name,description,quantity,price,cat_id,id);
                if(result == 1){
                    request.setAttribute("message","Product Updated Sucesssfully");
                    RequestDispatcher rq = request.getRequestDispatcher("prod.jsp");
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
