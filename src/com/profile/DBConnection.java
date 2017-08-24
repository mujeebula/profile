package com.profile;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/javaWebApp";
		String username = "root";
		String password = "mindfire";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} 
			catch (ClassNotFoundException e){
				e.printStackTrace();
			} 
			con =  (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("Printing connection object "+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; 
	}

}
