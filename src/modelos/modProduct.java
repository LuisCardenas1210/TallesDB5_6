/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author jovan
 */
public class modProduct {
    private String productCode;
    private String nam; 
    private double price;
    private int quantityAvailable;
    private int categoria;

    
    public boolean isEmpty() {
        return (productCode == null || productCode.isEmpty()) 
            || (nam == null || nam.isEmpty()) 
            || price <= 0 
            || quantityAvailable < 0;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
    
    public String getProductCode() {
        return productCode;
    }

    public String getNam() {
        return nam;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
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

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
    
    
}
