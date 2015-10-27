package com.ufu.disease.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection connect() {
		String dbUrl = "jdbc:mysql://localhost/agdisease";
		String dbClass = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "";
		try {
			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
