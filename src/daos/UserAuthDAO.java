
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;
import java.sql.*;
import modelos.modUser;
import jFrames.Conexion;
/**
 *
 * @author jovan
 */
public class UserAuthDAO {
    Conexion cx = new Conexion();
    public UserAuthDAO(){
    }

    
    public boolean verify(String usuarioID, String pass){
        try {
            String query = "select * from employees where pass=sha2('" + pass + "',256)and EmployeeID='" + usuarioID + "';";
            Statement st = cx.conectar().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                String userID   = rs.getString("EmployeeID");
                String name     = rs.getString("nam");
                String lastName = rs.getString("surname");
                modUser.getInstance().setUserId(userID);
                modUser.getInstance().setUsername(name);
                modUser.getInstance().setLastName(lastName);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

}
