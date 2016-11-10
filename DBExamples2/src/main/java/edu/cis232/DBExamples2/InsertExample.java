package edu.cis232.DBExamples2;

import java.sql.*;

public class InsertExample {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO COFFEE"
					 + " (Description,ProdNum,Price)"
					 + " VALUES "
					 + " ('Dan Medium Roast', '30-003', 12.95);";
		
		stmt.executeUpdate(sql);
		
		conn.close();
		
		System.out.println("Inserted Coffee!");
	}

}
