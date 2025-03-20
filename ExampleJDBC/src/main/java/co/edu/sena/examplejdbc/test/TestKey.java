/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.model.keys;
import java.util.List;

/**
 * Fecha: 15/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Proba consultas/transacciones en tabla key.
 */
public class TestKey {
    public static void main(String[] args) {
        BDKey bdKey = new BDKey();
        
        // Insertar
        keys key = new keys(5, "BICENTENARIO AMBIENTE 05", "Salon 205", 3, "Llaves prestadas");
//        bdKey.insertKey(keys);
        
        // Actualizar
        key.setName("ACTUALIZADO AMBIENTE 01");
        key.setRoom("Salon 206");
        key.setCount(3);
        key.setObservation("Llaves actualizadas");
        bdKey.updateKey(key);
        
        // Consultar todas las llaves
        List<keys> keysList = bdKey.getAllKeys();
        for (keys k : keysList) {
            System.out.println(k);
        }
        
        // Consultar una llave por ID
        keys keyById = bdKey.getKeyById(5);
        System.out.println(keyById);
    }
    }