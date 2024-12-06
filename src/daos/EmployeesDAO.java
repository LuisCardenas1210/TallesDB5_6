/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import jFrames.Conexion;
import modelos.modEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlobato
 */
public class EmployeesDAO {
    Conexion cx = new Conexion();
    public EmployeesDAO(){}
    public String create(modEmployee employee){
        String errors="";
        if (employee.getEmployeeID() == null || employee.getEmployeeID().length() > 24) 
            errors += "Employee ID is required and should not exceed 24 characters.\n";
        if (employee.getPass() == null) 
            errors += "Password is required.\n";
        if (employee.getNam() == null || employee.getNam().isEmpty()) 
            errors += "Name is required.\n";
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) 
            errors += "Email is required.\n";
        if (!employee.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ) 
            errors += "Invalid email format.\n";
        
        
        if (employee.getPhone1() == null || employee.getPhone1().length() > 12){
            errors += "Phone number is required and should not exceed 12 characters.\n";
        }
        
        if (employee.getRfc() != null && !employee.getRfc().isEmpty() && employee.getRfc().length() != 13) 
            errors += "RFC should be exactly 13 characters long.\n";
        if (employee.getPostalCode() != null && !employee.getPostalCode().isEmpty() && employee.getPostalCode().length() != 5) 
            errors += "Postal code should be exactly 5 characters long.\n";
        if(!errors.equals("")){
            return errors;
        }
        try{
            String checkQuery = "SELECT COUNT(*) FROM employees WHERE EmployeeID = ? OR ( RFC = ? AND RFC != '')";
            PreparedStatement checkStmt = cx.conectar().prepareStatement(checkQuery);
            checkStmt.setString(1, employee.getEmployeeID());
            checkStmt.setString(2, employee.getRfc());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                rs.close();
                checkStmt.close();
                cx.desconectar();
                errors += "The EmployeeID or RFC already exists in the database.\n";
                return errors;
            }
            rs.close();
            checkStmt.close();
            
            String insert = "insert into employees values(?,sha2(?,256),?,?,?,?,?,?,?,?);";
            PreparedStatement ps = cx.conectar().prepareStatement(insert);
            ps.setString(1, employee.getEmployeeID());
            ps.setString(2, employee.getPass());
            ps.setString(3, employee.getNam());
            ps.setString(4, employee.getSurname());
            ps.setString(5, employee.getRfc());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getPostalCode());
            ps.setString(8, employee.getCity());
            ps.setString(9, employee.getPhone1());
            ps.setString(10, employee.getEmail());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return "true";
        }
        catch(SQLException ex){
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
            errors += "Exception sql\n";
            return errors;
        }
    }
    
    public ArrayList<modEmployee> read(){
        ArrayList<modEmployee> list = new ArrayList<modEmployee>();
        try{
            String select = "select * from employees;";
            PreparedStatement ps = cx.conectar().prepareCall(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                modEmployee employee = new modEmployee();
                employee.setEmployeeID(rs.getString("employeeID"));
                employee.setNam(rs.getString("nam"));
                employee.setSurname(rs.getString("Surname"));
                employee.setRfc(rs.getString("rfc"));
                employee.setAddress(rs.getString("address"));
                employee.setPostalCode(rs.getString("postalCode"));
                employee.setCity(rs.getString("city"));
                employee.setPhone1(rs.getString("phone1"));
                employee.setEmail(rs.getString("email"));
                list.add(employee);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public modEmployee read(String employeeID) {
        modEmployee employee = new modEmployee();
        try {
            String select = "select * from employees where employeeID=?";
            PreparedStatement ps = cx.conectar().prepareStatement(select);
            ps.setString(1, employeeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee.setEmployeeID(rs.getString("EmployeeID"));
                employee.setNam(rs.getString("nam"));
                employee.setSurname(rs.getString("surname"));
                employee.setRfc(rs.getString("rfc"));
                employee.setAddress(rs.getString("address"));
                employee.setPostalCode(rs.getString("postalCode"));
                employee.setCity(rs.getString("city"));
                employee.setPhone1(rs.getString("phone1"));
                employee.setEmail(rs.getString("email"));
            }
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
    public String update(modEmployee employee) {
        String errors = "";
        if (employee.getEmployeeID() == null) 
            errors += "Employee ID is required.\n";
        else if (employee.getEmployeeID().length() > 24) 
            errors += "Employee ID must not exceed 24 characters.\n";

        if (employee.getNam() == null) 
            errors += "Name is required.\n";
        else if (employee.getNam().isEmpty()) 
            errors += "Name cannot be empty.\n";

        if (employee.getEmail() == null) 
            errors += "Email is required.\n";
        else if (employee.getEmail().isEmpty()) 
            errors += "Email cannot be empty.\n";
        else if (!employee.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) 
            errors += "Invalid email format.\n";

        if (employee.getPhone1() == null) 
            errors += "Phone number is required.\n";
        else if (employee.getPhone1().length() > 12) 
            errors += "Phone number must not exceed 12 characters.\n";

        if (employee.getRfc() != null && !employee.getRfc().isEmpty() && employee.getRfc().length() != 13) 
            errors += "RFC should be exactly 13 characters long.\n";
        if (employee.getPostalCode() != null && !employee.getPostalCode().isEmpty() && employee.getPostalCode().length() != 5) 
            errors += "Postal code should be exactly 5 characters long.\n";
      

        if (!errors.equals("")) {
            return errors; 
        }
        
        try {
            
            String update; //= "UPDATE employees SET firstName=?, lastName=?, taxID=?, address=?, postalCode=?, city=?, phone1=?, email=? WHERE employeeID=?";
            PreparedStatement ps; //= cx.conectar().prepareStatement(update);
            
            if (employee.getPass() != null && !employee.getPass().isEmpty()) {
                update = "UPDATE employees SET nam=?, surname=?, rfc=?, address=?, postalCode=?, city=?, phone1=?, email=?, pass=SHA2(?, 256) WHERE employeeID=?";
                ps = cx.conectar().prepareStatement(update);
                ps.setString(9, employee.getPass());
                ps.setString(10, employee.getEmployeeID());
            } else {
                update = "UPDATE employees SET nam=?, surname=?, rfc=?, address=?, postalCode=?, city=?, phone1=?, email=? WHERE employeeID=?";
                ps = cx.conectar().prepareStatement(update);
                ps.setString(9, employee.getEmployeeID());
            }

            
            ps.setString(1, employee.getNam());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getRfc());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPostalCode());
            ps.setString(6, employee.getCity());
            ps.setString(7, employee.getPhone1());
            ps.setString(8, employee.getEmail());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            
            return "Update successful";
        } catch (SQLException ex) {
            errors += "An error occurred while updating the employee.\n";
            return errors;
        }
    }
    
    public boolean delete(String employeeID) {
        try {
            String sqlDelete = "delete from employees where employeeID=?;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlDelete);
            ps.setString(1, employeeID);
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
