/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDEmployee;
import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.bd.BDRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.model.keys;
import java.util.List;

/**
 * Fecha: 20/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Proba consultas/transacciones en tabla record.
 */
public class TestRecord {
    public static void main(String[] args) {
        BDRecord bdr = new BDRecord();
        BDEmployee bde = new BDEmployee();
        BDKey bdk = new BDKey();
        
        // Insertar
        Employee employee = bde.findById(1117);
        keys key = bdk.getKeyById(4);
//        Record record = new Record(9, "2025-03-20", "06:30:00", "01:15:00", employee, key, "CANCELADO");
//        bdr.insert(record);

        //Actualizar
        Record recordUpdated = new Record(7, "2025-03-20", "07:00:00", "01:15:00", employee, key, "PENDIENTE");
        bdr.update(recordUpdated);
        
        //Eliminar
//        bdr.delete(9);

        // Consultar todos
        List<Record> records = bdr.findAll();
        for (Record e : records) {
            System.out.println("id: " + e.getId()
                    + " Start Time: " + e.getStart_time()
                    + " End Time: " + e.getEnd_time()
                    + " Employee: " + e.getEmployee().getFullname()
                    + " Key: " + e.getKey().getObservation()
                    + " Status: " + e.getStatus());
        }
        
        // Consultar por ID
        System.out.println("************************************************************************************************************************************");
        Record recordById = bdr.findById(7);
        if (recordById != null) {
            System.out.println("id: " + recordById.getId()
                    + " Start Time: " + recordById.getStart_time()
                    + " End Time: " + recordById.getEnd_time()
                    + " Employee: " + recordById.getEmployee().getFullname()
                    + " Key: " + recordById.getKey().getObservation()
                    + " Status: " + recordById.getStatus());
        }
        else {
            System.out.println("No existe el registro con ese ID");
        }
    }
}
