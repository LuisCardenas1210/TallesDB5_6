/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import jFrames.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.modProduct;

import java.sql.Connection;
/**
 *
 * @author jovan
 */
public class ProductDAO {
    Conexion cx = new Conexion();

    public ProductDAO() {}

    public String create(modProduct product) {
        String errors = "";
        if (product.getProductCode() == null || product.getProductCode().length() != 12) 
            errors += "Product Code must not be null and must be 12 characters long.\n";
        if (product.getNam() == null || product.getNam().isEmpty()) 
            errors += "Name must not be null or empty.\n";
        if (product.getPrice() < 0) 
            errors += "Price must not be negative.\n";
        if (product.getQuantityAvailable() < 0) 
            errors += "Quantity Available must not be negative.\n";

        if (!errors.equals("")) return errors;

        try {
            String insert = "INSERT INTO products (ProductCode, categoryID, Nam, Price, QuantityAvailable) "
                          + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = cx.conectar().prepareStatement(insert);
            ps.setString(1, product.getProductCode());
            ps.setInt(2, product.getCategoria());
            ps.setString(3, product.getNam());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantityAvailable());
            ps.execute();
            ps.close();
            cx.desconectar();
            return "true";
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "An error occurred while saving to the database.";
        }
    }

    public ArrayList<modProduct> read() {
        ArrayList<modProduct> list = new ArrayList<>();
        try {
            String select = "SELECT * FROM products;";
            PreparedStatement ps = cx.conectar().prepareCall(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modProduct product = new modProduct();
                product.setProductCode(rs.getString("ProductCode"));
                product.setNam(rs.getString("Nam"));
                product.setPrice(rs.getDouble("Price"));
                product.setQuantityAvailable(rs.getInt("QuantityAvailable"));
                list.add(product);
            }
            ps.close();
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public modProduct read(String productCode) {
        modProduct product = new modProduct();
        try {
            String select = "SELECT * FROM products WHERE ProductCode = ?;";
            PreparedStatement ps = cx.conectar().prepareStatement(select);
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setProductCode(rs.getString("ProductCode"));
                product.setNam(rs.getString("Nam"));
                product.setPrice(rs.getDouble("Price"));
                product.setQuantityAvailable(rs.getInt("QuantityAvailable"));
            }
            ps.close();
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public boolean delete(String productCode) {
        try {
            String sqlDelete = "DELETE FROM products WHERE ProductCode = ?;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlDelete);
            ps.setString(1, productCode);
            ps.execute();
            ps.close();
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public String update(modProduct product) {
        String errors = "";

        if (product.getProductCode() == null) 
            errors += "Product Code is required.\n";
        else if (product.getProductCode().length() != 12) 
            errors += "Product Code must not exceed 10 characters.\n";

        if (product.getNam() == null) 
            errors += "Name is required.\n";
        else if (product.getNam().isEmpty()) 
            errors += "Name cannot be empty.\n";

        if (product.getPrice() < 0) 
            errors += "Price must not be negative.\n";

        if (product.getQuantityAvailable() < 0) 
            errors += "Quantity Available cannot be negative.\n";

        if (!errors.equals("")) {
            return errors; 
        }

        try {
            String update = "UPDATE products SET categoryID=?,Nam = ?, Price = ?, QuantityAvailable = ? WHERE ProductCode = ?;";
            PreparedStatement ps = cx.conectar().prepareStatement(update);

            ps.setInt(1, product.getCategoria());
            ps.setString(2, product.getNam());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantityAvailable());
            ps.setString(5, product.getProductCode());

            ps.executeUpdate();
            ps.close();
            cx.desconectar();

            return "Update successful";
        } catch (SQLException ex) {
            errors += "An error occurred while updating the product.\n";
            return errors;
        }
    }
    
    public String decreaseProductQuantityWithTransaction(String productCode, int quantitySold) {
        if (quantitySold <= 0) {
            return "Quantity sold must be greater than zero.";
        }

        Connection connection = null;

        try {
            connection = cx.conectar();
            connection.setAutoCommit(false);

            String select = "SELECT QuantityAvailable FROM products WHERE ProductCode = ?;";
            PreparedStatement psSelect = connection.prepareStatement(select);
            psSelect.setString(1, productCode);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                int currentQuantity = rs.getInt("QuantityAvailable");

                if (currentQuantity < quantitySold) {
                    connection.rollback();  
                    return "Insufficient stock for the product; product: " + rs.getString("nam" + ", Stock: "+ rs.getInt("quantityAvailable"));
                }

                String update = "UPDATE products SET QuantityAvailable = QuantityAvailable - ? WHERE ProductCode = ?;";
                PreparedStatement psUpdate = connection.prepareStatement(update);
                psUpdate.setInt(1, quantitySold);
                psUpdate.setString(2, productCode);
                psUpdate.executeUpdate();

                connection.commit();

                return "Quantity successfully updated.";
            } else {
                connection.rollback();  
                return "Product not found.";
            }
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "An error occurred while updating the product quantity.";
        } finally {
           
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    cx.desconectar(); 
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
