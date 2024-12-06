/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author jovan
 */
public class modProductDetails {
    private String productCode;
    private String nam;
    private double price;
    private int    quantity;
    private double total;

    public String getProductCode() {
        return productCode;
    }

    public String getNam() {
        return nam;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
