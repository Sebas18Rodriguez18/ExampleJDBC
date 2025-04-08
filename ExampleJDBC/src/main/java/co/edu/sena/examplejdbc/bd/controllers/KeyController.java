/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.model.keys;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo Key.
 */
public class KeyController implements IKeyController{
    
    private BDKey dbk = new BDKey();

    @Override
    public void insertKey(keys keys) throws Exception {
        if(keys == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if("".equals(keys.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(keys.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(keys.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        //insertar
        dbk.insertKey(keys);
    }

    @Override
    public void updateKey(keys key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() == 0)
        {
            throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        //Consultar si el key existe en la bd.
        keys keysExist = dbk.getKeyById(key.getId());
        if(keysExist == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Actualizar
        dbk.updateKey(key);
    }

    @Override
    public void deleteKey(int id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        //Consultar si el key existe en la bd.
        keys keysExist = dbk.getKeyById(id);
        if(keysExist == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Eliminar
        dbk.deleteKey(id);
    }

    @Override
    public List<keys> getAllKeys() throws Exception {
        return dbk.getAllKeys();
    }

    @Override
    public keys getKeyById(int id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        return dbk.getKeyById(id);
    }
    
}
