/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;

import co.edu.sena.examplejdbc.model.keys;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo Key.
 */
public interface IKeyController {
    public void insertKey (keys keys) throws Exception;
    public void updateKey(keys key) throws Exception;
    public void deleteKey (int id) throws Exception;
    public List<keys> getAllKeys() throws Exception;
    public keys getKeyById(int id) throws Exception;
}
