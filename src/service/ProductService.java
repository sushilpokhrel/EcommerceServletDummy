package service;

import Domains.Products;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anish on 7/18/17.
 */
public class ProductService {

    public static List<Products> getprodList() throws SQLException, ClassNotFoundException {
        List prodList = new ArrayList<Products>();
        String query = "select * from products";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Products prod = new Products();
            prod.setId(rs.getInt("id"));
            prod.setCat_id(rs.getInt("cat_id"));
            prod.setName(rs.getString("name"));
            prod.setDescription(rs.getString("description"));
            prod.setQuantity(rs.getInt("quantity"));
            prod.setPrice(rs.getDouble("price"));
            prodList.add(prod);
        }
        return prodList;
    }

    public static int addProduct(String name, String description,int quantity, Double price, int cat_id ) throws SQLException, ClassNotFoundException {
        String query = "insert into products (name,description,quantity,cat_id,price) values (?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,name);
        pstm.setString(2,description);
        pstm.setInt(3,quantity);
        pstm.setInt(4,cat_id);
        pstm.setDouble(5,price);
        return pstm.executeUpdate();
    }

    public static int delete(int id) throws SQLException, ClassNotFoundException {
        String query = "delete from products where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setInt(1,id);
        return pstm.executeUpdate();
    }

    public static Products getProdbyId(int id) throws SQLException, ClassNotFoundException {
        Products prod = null;
        String query = "select * from products where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            prod = new Products();
            prod.setId(rs.getInt("id"));
            prod.setName(rs.getString("name"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(rs.getDouble("price"));
            prod.setQuantity(rs.getInt("quantity"));
        }
        return prod;
    }

    public static int updateProduct(String name, String description, int quantity, Double price, int cat_id, int id) throws SQLException, ClassNotFoundException {
        String query = "update products set name = ?,description = ? , quantity = ?, price = ?,cat_id = ? where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,name);
        pstm.setString(2,description);
        pstm.setInt(3,quantity);
        pstm.setDouble(4,price);
        pstm.setInt(5,cat_id);
        pstm.setInt(6,id);
        return pstm.executeUpdate();
    }

    public static List<Products> getTopProducts() throws SQLException, ClassNotFoundException {
        List prodList = new ArrayList<Products>();
        String query = "select * from products";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Products prod = new Products();
            prod.setId(rs.getInt("id"));
            prod.setCat_id(rs.getInt("cat_id"));
            prod.setName(rs.getString("name"));
            prod.setDescription(rs.getString("description"));
            prod.setQuantity(rs.getInt("quantity"));
            prod.setPrice(rs.getDouble("price"));
            prodList.add(prod);
        }
        return prodList;
    }
    public static List<Products> getProductsByCatId(int id) throws SQLException, ClassNotFoundException {
        List prodList = new ArrayList<Products>();
        String query = "select * from products where cat_id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Products prod = new Products();
            prod.setId(rs.getInt("id"));
            prod.setCat_id(rs.getInt("cat_id"));
            prod.setName(rs.getString("name"));
            prod.setDescription(rs.getString("description"));
            prod.setQuantity(rs.getInt("quantity"));
            prod.setPrice(rs.getDouble("price"));
            prodList.add(prod);
        }
        return prodList;
    }


}
