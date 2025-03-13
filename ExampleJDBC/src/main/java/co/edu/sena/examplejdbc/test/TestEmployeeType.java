/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Proba consultas/ttransacciones en tabla employee_type .
 */
public class TestEmployeeType {
    public static void main(String[] args) {
        BDEmployeeType bDEmployeeType = new BDEmployeeType();
        
        //Insertar
        EmployeeType employeeType = new EmployeeType(6, "SUBDIRECTOR");
//        bDEmployeeType.insert(employeeType);
        //Actualizar
//        employeeType.setId(5);
//        employeeType.setDescript("COORDINADOR");
//        bDEmployeeType.update(employeeType);
        //Delete
//        bDEmployeeType.delete(5);

        //Consultar
        System.out.println("******************************************************************************************");
        List<EmployeeType> listEmployeeTypes = bDEmployeeType.findAll();
        for (EmployeeType e : listEmployeeTypes) {
            System.out.println("id: " + e.getId() + "descript: " + e.getDescript());
        }
        
        //Consultar por id
        System.out.println("******************************************************************************************");
        EmployeeType employeeType2 = bDEmployeeType.findById(22);
        if (employeeType2 != null)
        {
        System.out.println("id: " + employeeType.getId() + "descript: " + employeeType2.getDescript());   
        }
        
        else
        {
            System.out.println("No existe el Empleado con ese id ");
        }
    }
}
