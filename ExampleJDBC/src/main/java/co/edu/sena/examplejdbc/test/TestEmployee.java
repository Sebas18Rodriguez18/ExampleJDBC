/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDEmployee;
import co.edu.sena.examplejdbc.bd.BDEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Fecha: 20/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Proba consultas/transacciones en tabla employee .
 */
public class TestEmployee {
    public static void main(String[] args) {
        BDEmployee bde = new BDEmployee();
        BDEmployeeType bdet = new BDEmployeeType();
        
        //Insertar
        EmployeeType employeeType = bdet.findById(1);
        Employee employee = new Employee(1107843290, "ELSA BROSÓN", "Av 5a", "310", employeeType);
//        bde.insert(employee);
        
        //Actualizar
        employee.setFullname("ELTON TITTO");
        employeeType = bdet.findById(2);
        employee.setEmployeeType(employeeType);
//        bde.update(employee);
        
        //Eliminar
        bde.delete(1107843290);
        
        
        //Consultar todos
        List<Employee> employees = bde.findAll();
        for(Employee e : employees){
            System.out.println("document: " + e.getDocument() 
                    + " fullname: " + e.getFullname() 
                    + " address: " + e.getAddress()
                    + " phone: " + e.getPhone()
                    + " type: "+ e.getEmployeeType().getDescript());
        }
        
        //consultar por ID
        System.out.println("************************************************************************************************************************************");
        Employee employee2 = bde.findById(1000000003);
        System.out.println("document: " + employee2.getDocument() 
                    + " fullname: " + employee2.getFullname() 
                    + " address: " + employee2.getAddress()
                    + " phone: " + employee2.getPhone()
                    + " type: "+ employee2.getEmployeeType().getDescript());
    }
}
