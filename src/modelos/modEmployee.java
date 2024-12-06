/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author jlobato
 */
public class modEmployee {
    private String employeeID;
    private String pass;
    private String nam;
    private String surname;
    private String rfc;
    private String address;
    private String postalCode;
    private String city;
    private String phone1;
    private String email;

    public modEmployee(){}

    public modEmployee(String employeeID, String pass, String nam, String surname, String rfc, String address, String postalCode, String city, String phone1, String email) {
        this.employeeID = employeeID;
        this.pass = pass;
        this.nam = nam;
        this.surname = surname;
        this.rfc = rfc;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone1 = phone1;
        this.email = email;
    }

    // Getters and setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
