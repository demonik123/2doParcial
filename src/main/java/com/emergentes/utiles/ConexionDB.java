
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionDB {
    
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_seminarios";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
               System.out.println("ERROR EN EL DRIVER: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONEXION: "+ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
        
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
