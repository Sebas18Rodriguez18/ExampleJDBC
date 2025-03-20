/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.model.keys;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 20/03/2025
 *
 * @author Sebastian Rodriguez Objetivo: Permite consultas y transacciones en la
 * tabla record.
 */
public class BDRecord extends BDConnection {

    public void insert(Record record) {
        try {
            connect();
            String sql = "INSERT INTO record (date_record, start_time, end_time, employee_id, key_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDate_record());
            preparedStatement.setString(2, record.getStart_time());
            preparedStatement.setString(3, record.getEnd_time());
            preparedStatement.setLong(4, record.getEmployee().getDocument()); // FK
            preparedStatement.setInt(5, record.getKey().getId()); // FK
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar record" + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void update(Record record){ 
    try {
            connect();
            String sql = "update `record` SET date_record = ?, start_time = ?, end_time = ?, employee_id = ?, key_id = ?, status = ? WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDate_record());
            preparedStatement.setString(2, record.getStart_time());
            preparedStatement.setString(3, record.getEnd_time());
            preparedStatement.setLong(4, record.getEmployee().getDocument()); // FK
            preparedStatement.setInt(5, record.getKey().getId()); // FK
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.setInt(7, record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar el registro" + e.getMessage());
        }
        finally {
            disconnect();
        }
    }

    public void delete(int id){
       try {
            connect();
            String sql = "delete from record where id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) 
        {
            MessageUtils.showErrorMessage("Error al eliminar el registro " + e.getMessage());
        }
        
        finally
        {
            disconnect();
        }
    }
    
    public List<Record> findAll() {
        List<Record> results = new ArrayList<>();
        BDEmployee bde = new BDEmployee();
        BDKey bdk = new BDKey();

        try {
            connect();
            String sql = "SELECT * FROM record";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                // FK's
                Employee employee = bde.findById(resultSet.getInt("employee_id"));
                keys key = bdk.getKeyById(resultSet.getInt("key_id"));
                record.setEmployee(employee);
                record.setKey(key);
                // Norm
                record.setStatus(resultSet.getString("status"));
                results.add(record);
            }
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar records: " + e.getMessage());
        } finally {
            disconnect();
        }
        return results;
    }
}
