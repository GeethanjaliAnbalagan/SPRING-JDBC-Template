package com.java.JDBC.preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JdbcInsertDemo {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "Test123@";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			
			//INSERT INTO Users (username, password, fullname, email) VALUES ("geetha", "123", "anjali", "gee@mail");
			//INSERT INTO Users (username, password, fullname, email) VALUES ("geetha", "123", "anjali", "gee@mail");
			
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "sanjith123");
			statement.setString(2, "1234");
			statement.setString(3, "geethanjali");
			statement.setString(4, "geetha@microsoft.com");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}