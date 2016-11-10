package edu.cis232.DBExamples2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee";
    	
    	//Fields you'd like to extract from the data (Select columnNames)
    	//Table(s) that you'd like to extract the data from (From tableName)
    	//Optional Filter (where CONDITIONS)
    	//Optional Ordering (order by columnNames desc)
    	
    	String sqlStatement = "SELECT * FROM COFFEE ORDER BY DESCRIPTION";
    	
    	Connection conn = DriverManager.getConnection(DB_URL);
    	
    	Statement stmt = conn.createStatement();
    	
    	ResultSet result = stmt.executeQuery(sqlStatement);
    	
    	while(result.next()){
    		System.out.println(result.getString("description") + " " + result.getDouble("price"));
    	}
    	
    	conn.close();
    }
}
