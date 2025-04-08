/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.BDRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo Record.
 */
public class RecordController implements IRecordController{
    
    private BDRecord dbr = new BDRecord();

    @Override
    public void insert(Record record) throws Exception {
        if (record == null)
        {
            throw  new Exception("El registro es nulo");
        }
        
        if ("".equals(record.getDate_record()))
        {
            throw  new Exception("La fecha es obligatoria");
        }
        
        if ("".equals(record.getStart_time()))
        {
            throw  new Exception("La hora de inicio es obligatoria");
        }
        
        if ("".equals(record.getEnd_time()))
        {
            throw  new Exception("La hora de fin es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw  new Exception("El estado es obligatorio");
        }
        
        //FK's
        if(record.getEmployee() == null)
        {
            throw  new Exception("El id del empleado es obligatorio");
        }
        
        if(record.getKey() == null)
        {
            throw  new Exception("La llave es obligatoria");
        }
        
        dbr.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null)
        {
            throw  new Exception("El registro es nulo");
        }
        
        if(record.getId() == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        if ("".equals(record.getDate_record()))
        {
            throw  new Exception("La fecha es obligatoria");
        }
        
        if ("".equals(record.getStart_time()))
        {
            throw  new Exception("La hora de inicio es obligatoria");
        }
        
        if ("".equals(record.getEnd_time()))
        {
            throw  new Exception("La hora de fin es obligatoria");
        }
        
        //FK's
        if(record.getEmployee() == null)
        {
            throw  new Exception("El id del empleado es obligatorio");
        }
        
        if(record.getKey() == null)
        {
            throw  new Exception("La llave es obligatoria");
        }
        
        //La FK no es autoincremental, se debe validar existencia del registro.
        Record recordExists = dbr.findById(record.getId());
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        Record recordExists = dbr.findById(id);
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        dbr.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
       return  dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        Record recordExists = dbr.findById(id);
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        return dbr.findById(id);
    }
    
}
