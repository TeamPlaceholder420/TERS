/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class OracleJDBCConnection {
    
 public static String JDBC_CONNECTION_DRIVER =  "oracle.jdbc.driver.OracleDriver"; 
 //public static String  CONNECTION_STRING = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl," + "sli00011238,"+ "sli00011238";
 public static String  CONNECTION_STRING = "jdbc:oracle:thin:b00059587/b00059587@coeoracle.aus.edu:1521:orcl";
 public static Connection connectDataBase()
 {
     System.out.println("-------- Oracle JDBC Connection Testing ------");
 
		try {
 
			Class.forName(JDBC_CONNECTION_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
 
		}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(CONNECTION_STRING);
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 }
 		if (connection != null) {
                    System.out.println("Connectioned to database");
			return connection;
		} else {
                    System.out.println("Connection Failed! Check");
			return null;
		}
                
 }
 
}