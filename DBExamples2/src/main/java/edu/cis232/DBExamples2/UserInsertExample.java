package edu.cis232.DBExamples2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInsertExample {

	public static void main(String[] args) throws SQLException{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me a description:");
		String desc = keyboard.nextLine();
		System.out.println("Give me a product number:");
		String prod = keyboard.nextLine();
		System.out.println("Give me a price:");
		String price = keyboard.nextLine();
		
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
	
		String sql = "INSERT INTO COFFEE"
					 + " (Description,ProdNum,Price)"
					 + " VALUES "
					 + " (?, ?, ?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, desc);
		stmt.setString(2, prod);
		stmt.setDouble(3, Double.parseDouble(price));
		
		stmt.executeUpdate();
		
		conn.close();
		
		System.out.println("Inserted Coffee!");
	}

}
