package com.pizzeria.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPizzeria {

	
	
	public static void main(String[] args) {
		
		
		Connection conn = null;
		
		
		try {
			
			conn = ConnectionPizzeria.getConnection();
			System.out.println("La connexion fonctionne");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				conn.close();
				
			} catch (SQLException e) {
				
			}
			
		}
		
		

	}
	
	
	
	public static Connection getConnection() throws SQLException {
		
		String driver = null;
		String username = null;
		String password = null;
		String url = null;
		
		Properties props = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream("./parameters.properties");
			
			props.load(fis);
			
			username = props.getProperty("jdbc.username");
			
			password = props.getProperty("jdbc.password");
			
			driver = props.getProperty("jdbc.driver");
			
			url = props.getProperty("jdbc.url");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {


			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url, username, password);
		
	}

}
