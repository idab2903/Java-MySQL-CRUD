/*
 * BD.java
 *
 * Created on 10 de septiembre de 2007, 04:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pruebaodbc;

/**
 *
 * @author modelo
 */

import java.sql.*;

public class bd{

    static String bd = "imagenes";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection connection = null;

    public bd(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            connection.close();
        }catch(Exception ex){}
    }


}
