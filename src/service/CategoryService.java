package service;

import Domains.Category;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anish on 7/18/17.
 */
public class CategoryService {

    public static List<Category> getCatList() throws SQLException, ClassNotFoundException {
        List<Category> categoryList = new ArrayList<Category>();
        String query = "select * from categories";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static int addCategory(String name, String description) throws SQLException, ClassNotFoundException {
        String query = "insert into categories (name,description) values (?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,name);
        pstm.setString(2,description);
        int result = pstm.executeUpdate();
        return result;

    }

    public static int deleteCategory(int id) throws SQLException, ClassNotFoundException {
        String query = "delete from categories where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setInt(1,id);
        return pstm.executeUpdate();

    }

    public static Category getCategory(int id) throws SQLException, ClassNotFoundException {
        Category cat = null;
        String query = "select * from categories where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            cat = new Category();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            cat.setDescription(rs.getString("description"));
        }
        return cat;
    }

    public static int updateCategory(int id,String name, String description) throws SQLException, ClassNotFoundException {
        String query = "update categories set name = ?, description = ? where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,name);
        pstm.setString(2,description);
        pstm.setInt(3,id);
        return pstm.executeUpdate();


    }
}
