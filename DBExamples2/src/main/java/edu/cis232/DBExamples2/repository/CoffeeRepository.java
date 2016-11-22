package edu.cis232.DBExamples2.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cis232.DBExamples2.model.Coffee;

public class CoffeeRepository {
	final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee";
	
	public List<Coffee> findByDescriptionLike(String description){
		ArrayList<Coffee> coffees = new ArrayList<Coffee>();
		// Create a connection to the database.
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			PreparedStatement stmt = conn.prepareStatement(
					"Select prodNum, description, price from Coffee where description like ?");
			stmt.setString(1, description);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Coffee c = new Coffee(result.getString("description"), result.getString("prodNum"), result.getDouble("price"));
				coffees.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return coffees;
	}
	
	public Coffee findByProdNum(String prodNum){
		Coffee c = null;
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			PreparedStatement stmt = conn.prepareStatement(
					"Select prodNum, description, price from Coffee where prodNum = ?");
			stmt.setString(1, prodNum);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				c = new Coffee(result.getString("description"), result.getString("prodNum"), result.getDouble("price"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public void save(Coffee coffee){
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			Coffee c = findByProdNum(coffee.getProdNum());
			if(c != null){
				//Coffee already exists, update
				PreparedStatement stmt = conn.prepareStatement(
						"Update Coffee set description = ?, price = ? WHERE prodNum = ?");
				stmt.setString(1, coffee.getDescription());
				stmt.setDouble(2, coffee.getPrice());
				stmt.setString(3, coffee.getProdNum());
				stmt.executeUpdate();
			} else {
				//Coffee does not exist, insert
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO Coffee(prodNum, description, price) values (?,?,?)");
				stmt.setString(1, coffee.getProdNum());
				stmt.setString(2, coffee.getDescription());
				stmt.setDouble(3, coffee.getPrice());
				stmt.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
