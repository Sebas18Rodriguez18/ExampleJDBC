/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.model.keys;

/**
 * Fecha: 15/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Proba consultas/transacciones en tabla key.
 */
public class TestKey {
    public static void main(String[] args) {
        BDKey keys = new BDKey();
        
        //Insertar
        keys key = new keys(5, "BICENTENARIO AMBIENTE 01", "Salon 205", 2, "Llaves prestadas");
        keys.insertKey(key);
    }
}
