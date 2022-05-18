package com.pack.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class JDBCCon {
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "vivekkasql");
			System.out.println("connected to db");

		}
		return connection;
	}
}
