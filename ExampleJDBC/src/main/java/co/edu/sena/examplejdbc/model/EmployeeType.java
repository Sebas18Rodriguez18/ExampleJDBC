/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *
 * @author Aprendiz
 */
public class EmployeeType {
   private int id;
   private String descript;

    public EmployeeType() {
    }

    public EmployeeType(int id, String descript) {
        this.id = id;
        this.descript = descript;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   
}
