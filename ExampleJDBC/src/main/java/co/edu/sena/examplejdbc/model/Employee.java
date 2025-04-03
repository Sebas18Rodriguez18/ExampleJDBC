/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 * Fecha: 15/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Instanciar los objetos de la tabla Employee.
 */
public class Employee {
    private long document;
    private String fullname;
    private String address;
    private String phone;
    private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(long document, String fullname, String address, String phone, EmployeeType employeeType) {
        this.document = document;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.employeeType = employeeType;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return fullname;
    }
}
