/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import jFrames.Conexion;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.modReporteTrimestral;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import modelos.modReporteMensual;
import modelos.modReporteEmpleado;

/**
 *
 * @author jovan
 */
public class salesReportDAO {

    Conexion cx = new Conexion();

    public salesReportDAO() {

    }

    public ArrayList<modReporteTrimestral> readA() {
        ArrayList<modReporteTrimestral> list = new ArrayList<modReporteTrimestral>();
        try {
            //aqui defino la consulta
            String select = "SELECT * FROM reporte_ventas_trimestrales";
            PreparedStatement ps = cx.conectar().prepareCall(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modReporteTrimestral reporte = new modReporteTrimestral();
                reporte.setProducto(rs.getString("producto"));
                reporte.setTrim1(rs.getDouble("trim 1"));
                reporte.setTrim2(rs.getDouble("trim 2"));
                reporte.setTrim3(rs.getDouble("trim 3"));
                reporte.setTrim4(rs.getDouble("trim 4"));
                list.add(reporte);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<modReporteMensual> readB(String anio, int month) {
        ArrayList<modReporteMensual> list = new ArrayList<modReporteMensual>();
        try {
            String select = "call salesReport_month(?,?);";
            PreparedStatement ps = cx.conectar().prepareCall(select);
            ps.setString(1, anio);
            ps.setInt(2, month);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modReporteMensual reporte = new modReporteMensual();
                reporte.setNumOrden(rs.getInt("Num.Orden"));
                reporte.setFecha(rs.getString("Fecha"));
                reporte.setCliente(rs.getString("Cliente"));
                reporte.setEmpleado(rs.getString("Empleado"));
                reporte.setTotal(rs.getInt("Total"));
                reporte.setCantDetalles(rs.getInt("Cant.Detalles"));
                list.add(reporte);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<modReporteEmpleado> readC(String anio, int month) {
        ArrayList<modReporteEmpleado> list = new ArrayList<modReporteEmpleado>();
        try {
            //aqui defino la consulta
            String select = "call saleReport_byEmployee(?,?);";
            PreparedStatement ps = cx.conectar().prepareCall(select);
            ps.setString(1, anio);
            ps.setInt(2, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modReporteEmpleado reporte = new modReporteEmpleado();
                reporte.setEmpleado(rs.getString("Empleado"));
                reporte.setTotal(rs.getDouble("Total"));
                reporte.setCantVentas(rs.getInt("Cant. Ventas"));
                list.add(reporte);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
