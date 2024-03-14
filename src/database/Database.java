/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author thanh
 */
public class Database {

	private final String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO192";
	private final String userName = "sa";
	private final String password = "181198";

	public void addEmployee(String id, String name, String position, double daySalary, int workDays) {
		String sql = "INSERT INTO Employees  (id, name, position, daySalary, workDays) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, position);
			statement.setDouble(4, daySalary);
			statement.setInt(5, workDays);

			if (statement.executeUpdate() > 0) {
				System.out.println("Employee has been saved!");
			}
		} catch (SQLException e) {
		}
	}
}
