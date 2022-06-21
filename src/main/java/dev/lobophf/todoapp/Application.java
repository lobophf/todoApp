package dev.lobophf.todoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dev.lobophf.todoapp.util.ConnectionFactory;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Hi");

		Connection con = ConnectionFactory.getConnection();
		ConnectionFactory.closeConnection(con);
	}
}
