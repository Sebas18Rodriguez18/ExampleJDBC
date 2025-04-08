/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.keys;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 15/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Permite consultas y transacciones en la tabla key .
 */

public class BDKey extends BDConnection{
        public void insertKey (keys keys)
    {
        try {
            connect();
            String sql = "insert into `key` (name, ) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, keys.getId());
            preparedStatement.setString(2, keys.getName());
            preparedStatement.setString(3, keys.getRoom());
            preparedStatement.setInt(4, keys.getCount());
            preparedStatement.setString(5, keys.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar una llave: " + e.getMessage());
        } finally {
            disconnect();
        }
    }
    
        public void updateKey(keys key) {
        try {
            connect();
            String sql = "UPDATE `key` SET name = ?, room = ?, count = ?, observation = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.setInt(5, key.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar una llave: " + e.getMessage());
        } finally {
            disconnect();
        }
    }
    
    public void deleteKey (int id)
    {
        try {
            connect();
            String sql = "delete from `key` where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar una llave" + e.getMessage());
        } 
        finally {
            disconnect();
        }
    }
    
    public List<keys> getAllKeys() {
        List<keys> keysList = new ArrayList<>();
        try {
            connect();
            String sql = "SELECT * FROM `key`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                keys key = new keys(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("room"),
                    resultSet.getInt("count"),
                    resultSet.getString("observation")
                );
                keysList.add(key);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al obtener todas las llaves: " + e.getMessage());
        } finally {
            disconnect();
        }
        return keysList;
    }
    
    public keys getKeyById(int id) {
        keys key = null;
        try {
            connect();
            String sql = "SELECT * FROM `key` WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                key = new keys(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("room"),
                    resultSet.getInt("count"),
                    resultSet.getString("observation")
                );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al obtener la llave por ID: " + e.getMessage());
        } finally {
            disconnect();
        }
        return key;
    }

}