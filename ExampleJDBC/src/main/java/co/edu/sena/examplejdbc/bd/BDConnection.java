/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Fecha: 13/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Clase principal para conexión a base de datos.
 */
public class BDConnection {
    public static Connection connection;
    public static Statement statement;
    
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String BD = "bdkeys";
    private final String USER = "developer";
    private final String PASSWORD = "developer";
    
    public void connect()
    {
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST +  ":" + PORT + "/" + BD, USER,  PASSWORD);
            
            statement = connection.createStatement();
            System.out.println("Conectado!");
        } 
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            MessageUtils.showErrorMessage("Error de conexión a la base de datos");
        }
    }
    
    public void disconnect()
    {
        try {
            if(statement != null)
            {
                statement.close();
            }
            
            if(connection != null)
            {
                connection.close();
            }
            
            System.out.println("Desconectado!");
        }
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error  desconectandose de la BD");
        }
    }
}
