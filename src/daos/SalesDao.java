/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import jFrames.Conexion;
import java.util.ArrayList;
import modelos.modSales;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.modProduct;
import modelos.modOrders;

/**
 *
 * @author Fatima Lizbeth
 */
public class SalesDao {
    Conexion cx=new Conexion();

    public SalesDao() {
    }
    
    public boolean createOrder(String fecha, String employeeid, String customerid){
        try {
            String query="insert into orders (date,employeeid,customerid)values(?,?,?);";
            PreparedStatement ps=cx.conectar().prepareStatement(query);
            ps.setString(1, fecha);
            ps.setString(2, employeeid);
            ps.setString(3, customerid);
            ps.execute();
            /*ResultSet rs = ps.executeQuery();
            while(rs.next()){
                modOrders employee = new modOrders();
                employee.setOrderid(rs.getInt("OrderID"));
                employee.setDate(rs.getString("date"));
                employee.setEmployeeid(rs.getString("EmployeeID"));
                employee.setCustomerid(rs.getString("CustomerID"));
            }*/
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void read(){
        try {    
            String select="select * from orders order by orderid desc limit 1;";
            PreparedStatement ps=cx.conectar().prepareStatement(select);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                modOrders.getInstance().setOrderid(rs.getInt("OrderID"));
                modOrders.getInstance().setDate(rs.getString("Date"));
                modOrders.getInstance().setEmployeeid(rs.getString("EmployeeID"));
                modOrders.getInstance().setCustomerid(rs.getString("CustomerID"));
            }
            ps=null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createOrderDetails(int orderid,modProduct producto, int quantity){
        try {
            String insert="call insertOrderDetails(?, ?, ?, ?);";
            PreparedStatement ps=cx.conectar().prepareStatement(insert);
            ps.setInt(1, orderid);
            ps.setString(2, producto.getProductCode());
            ps.setInt(3, quantity);
            ps.setDouble(4, producto.getPrice());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /*
    public ArrayList<modSales> read(int orderNumber) {
    ArrayList<modSales> list = new ArrayList<modSales>();
    try {
        String select = "select * from orders where orderNumber = ?;";
        PreparedStatement ps = cx.conectar().prepareStatement(select);
        ps.setInt(1, orderNumber);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            modSales sales = new modSales();
            sales.setOrderID(rs.getInt("OrderID"));
            sales.setOrderNumber(rs.getInt("orderNumber"));
            sales.setProductName(rs.getString("productName"));
            sales.setPrice(rs.getDouble("price"));
            sales.setQuantity(rs.getInt("quantity"));
            sales.setTotal(rs.getDouble("total"));
            sales.setDate(rs.getString("date"));
            sales.setEmployeeID(rs.getString("EmployeeID"));
            sales.setCustomerID(rs.getString("CustomerID"));
            sales.setProductCode(rs.getString("ProductCode"));
            list.add(sales);
        }
        ps.close();
        ps = null;
        cx.desconectar();
        
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    */
    
    public modSales read(int idOrdenes){
        modSales sale=new modSales();
        return sale;
    }
    
    public boolean delete(int idOrdenes){
        return true;
    }
    /*
    public ArrayList<modMensajes> read() {
        ArrayList<modMensajes> lista = new ArrayList<modMensajes>();
        try {
            String select = "select * from mensaje;";
            PreparedStatement ps = cx.conectar().prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modMensajes mensajes = new modMensajes();
                mensajes.setIdMensaje(rs.getInt("id_mensaje"));
                mensajes.setMensaje(rs.getString("mensaje"));
                mensajes.setAutor(rs.getString("autor"));
                mensajes.setDestinatario(rs.getString("destinatario"));
                lista.add(mensajes);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(daoMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
}
