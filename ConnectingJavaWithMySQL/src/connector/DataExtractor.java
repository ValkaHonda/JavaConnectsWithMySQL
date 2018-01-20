package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataExtractor {
	private static final String FIX = "?autoReconnect=true&useSSL=false";
	private static final String URL = "jdbc:mysql://localhost:3306/minions"+FIX;
	private static final String USER = "root";
	private static final String PASS = "883368107754";
	

	public static void main(String[] args) {
		try (Connection mySQLConnection = DriverManager.getConnection(URL,USER,PASS)){
			
			Statement statement = mySQLConnection.createStatement();
			ResultSet set = statement.executeQuery("SELECT * FROM minions");
			while(set.next()) {
				System.out.println(set.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
