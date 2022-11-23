/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUYVU
 */
public class DBConnection {
    private static String hostName = "localhost";
    private static String account = "sa";
    private static String pass = "632003";
    private static String dbName = "ASM_JAVA3";
    private static String connectionSQL = "jdbc:sqlserver://"+hostName+":1433;databaseName=" +dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection cnn;
    
    // LOAD DRIVER
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
        }
    }
    
    // Mo ket noi 
    public static Connection openDBConnection(){
        try {
            return DriverManager.getConnection(connectionSQL, account,pass );
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

