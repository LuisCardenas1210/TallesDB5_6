/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
idOrdenes int primary key,
nombreProducto varchar(40),
precio decimal(6,2) not null,
cantidad tinyint not null,
descuento char(3) default 0,
total decimal(6,2) not null,
fecha datetime,
idEmpleado char(10),
constraint idEmpleado foreign key (idEmpleado)
references empleados(idEmpleado),
idCliente char(10),
constraint idCliente foreign key (idCliente)
references clientes(idCliente),
CodigoProducto char(12),
constraint CodigoProducto foreign key(CodigoProducto)
references productos(CodigoProducto)
 */
public class modSales {
    int orderID;
    int orderNumber;
    String productName;
    double price;
    int quantity;
    double total;
    String date;
    String employeeID;
    String customerID;
    String productCode;

    public modSales() {
    }

    public modSales(int orderID, String productName, double price, int quantity, double total, String date, String employeeID, String customerID, String productCode) {
        this.orderID = orderID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.productCode = productCode;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
}
