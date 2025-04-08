/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.BDEmployee;
import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo EmployeeType.
 */
public class EmployeeController implements IEmployeeController{

    private BDEmployee dbe = new BDEmployee();
    
    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null)
        {
            throw  new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname()))
        {
            throw  new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getAddress()))
        {
            throw  new Exception("La direccion es obligatoria");
        }
        
        if ("".equals(employee.getPhone()))
        {
            throw  new Exception("El telefóno es obligatorio");
        }
        
        //FK
        if (employee.getEmployeeType() == null)
        {
            throw  new Exception("El tipo de empleado es obligatorio");
        }
        
        //La FK no es autoincremental, se debe validar existencia del empleado
        Employee employeeExists = dbe.findById(employee.getDocument());
        if (employeeExists != null)
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        dbe.insert(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null)
        {
            throw  new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname()))
        {
            throw  new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getAddress()))
        {
            throw  new Exception("La direccion es obligatoria");
        }
        
        if ("".equals(employee.getPhone()))
        {
            throw  new Exception("El telefóno es obligatorio");
        }
        
        //FK
        if (employee.getEmployeeType() == null)
        {
            throw  new Exception("El tipo de empleado es obligatorio");
        }
       
        Employee employeeExists = dbe.findById(employee.getDocument());
        if (employeeExists == null)
        {
            throw new Exception("No existe un empleado con ese documento");
        }
        
        dbe.update(employee);
    }

    @Override
    public void delete(long document) throws Exception {
        if (document == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        Employee employeeExists = dbe.findById(document);
        if (employeeExists == null)
        {
            throw new Exception("No existe un empleado con ese documento");
        }
        
        dbe.delete(document);
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return dbe.findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if (document == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        return dbe.findById(document);
    }
    
}
