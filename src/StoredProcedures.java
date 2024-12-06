/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stored.procedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author braua
 */
public class StoredProcedures {

    // Datos de conexión a la base de datos
    private static final String DB = "pointOfSale";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB;
    private static final String USER = "root";
    private static final String PASSWORD = "rammus";

    // Método para establecer conexión con la base de datos
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Procedimiento para insertar un cliente
    public static void insertCustomer(String customerID, String name, String surname, String address,
                                      String postalCode, String city, String phone, String email) {
        String sql = "{CALL insert_customer(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, customerID);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.setString(4, address);
            stmt.setString(5, postalCode);
            stmt.setString(6, city);
            stmt.setString(7, phone);
            stmt.setString(8, email);

            stmt.execute();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Procedimiento para actualizar un cliente
    public static void updateCustomer(String customerID, String name, String surname, String address,
                                      String postalCode, String city, String phone, String email) {
        String sql = "{CALL update_customer(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, customerID);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.setString(4, address);
            stmt.setString(5, postalCode);
            stmt.setString(6, city);
            stmt.setString(7, phone);
            stmt.setString(8, email);

            stmt.execute();
            System.out.println("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Procedimiento para eliminar un cliente
    public static void deleteCustomer(String customerID) {
        String sql = "{CALL delete_customer(?)}";
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, customerID);

            stmt.execute();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal para probar los procedimientos almacenados
    public static void main(String[] args) {
        // Insertar un cliente
        insertCustomer("CU12345678", "Juan", "Perez", "Calle Falsa 123",
                       "12345", "Ciudad", "1234567890", "juan.perez@example.com");

        // Actualizar un cliente
        updateCustomer("CU12345678", "Juan", "Garcia", "Av. Real 456",
                       "54321", "Ciudad Nueva", "0987654321", "juan.garcia@example.com");

        // Eliminar un cliente
        deleteCustomer("CU12345678");
    }
}
