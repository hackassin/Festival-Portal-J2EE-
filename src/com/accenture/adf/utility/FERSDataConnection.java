package com.accenture.adf.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A helper class that centralizes the management of data connections in the underlying database. <br/>
 * 
 */

public class FERSDataConnection {
	
    public FERSDataConnection()
    {
    	//System.out.println("Duke");
    }
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try{
			//Step-1 loading JDBC Driver
			//System.out.println("Durga hajigala");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded successfully");
			
			//Step-2 Establishing Connection
				//System.out.println("Driver hajigala");
				String url = "jdbc:mysql://localhost:3306/festivaldatabase";
				String user = "root";
				String password = "root";
				
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Connection initiated");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver class not found...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Not Found");
		}
		return connection;
	}

	
}
