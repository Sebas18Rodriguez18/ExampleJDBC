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
            String sql = "insert into key values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, keys.getId());
            preparedStatement.setString(2, keys.getName());
            preparedStatement.setString(3, keys.getRoom());
            preparedStatement.setInt(4, keys.getCount());
            preparedStatement.setString(5, keys.getObservation());
            preparedStatement.close();
            preparedStatement.executeUpdate();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar una llave" + e.getMessage());
        }
        finally {
            disconnect();
        }
    }
    
    public void updateKey (keys keys)
    {
        try {
            connect();
            String sql = "update employee_type set descript = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, keys.getId());
            preparedStatement.setString(2, keys.getName());
            preparedStatement.setString(3, keys.getRoom());
            preparedStatement.setInt(4, keys.getCount());
            preparedStatement.setString(5, keys.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar llaves" + e.getMessage());
        }
        finally {
            disconnect();
        }
    }
    
    public void deleteKey (int id)
    {
        try {
            connect();
            String sql = "delete from key where id = ?";
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
    
    public List<keys> findAllKeys()
    {
         List<keys> results = new ArrayList<>();
         
         try {
            connect();
            String sql = "select * from key";
            statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
             
             while (resultSet.next()) {                 
                 keys key = new keys();
                 key.setId(resultSet.getInt("id"));
                 key.setName(resultSet.getString("name"));
                 key.setRoom(resultSet.getString("room"));
                 key.setCount(resultSet.getInt("count"));
                 key.setObservation(resultSet.getString("observation"));
                 
                 results.add(key);
                }
             resultSet.close();
        } 
         catch (SQLException e) {
             MessageUtils.showErrorMessage("Error al consultar tipos llaves"  + e.getMessage());
        }
         finally {
             disconnect();
         }
         
         return results;
    }
    
    public keys findByIdKey (int id)
    {
        keys keys = null;
         try {
            connect();
            String sql = "select * from key where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
             
             if (resultSet.next()) {                 
                 keys key = new keys();
                 key.setId(resultSet.getInt("id"));
                 key.setName(resultSet.getString("name"));
                 key.setRoom(resultSet.getString("room"));
                 key.setCount(resultSet.getInt("count"));
                 key.setObservation(resultSet.getString("observation"));
             }
             
             resultSet.close();
             preparedStatement.close();
        } 
         catch (SQLException e) {
             MessageUtils.showErrorMessage("Error al consultar llaves"  + e.getMessage());
        }
         finally {
             disconnect();
         }
         
         return keys;
    }
}
