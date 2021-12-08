package com.java.JDBC.preparedstatement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "Test123@";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "QGbatch");
			statement.setString(2, "Reactbatch");
			statement.setString(3, "QGREACT@gatesfoundation.org");
			statement.setString(4, "bill");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}