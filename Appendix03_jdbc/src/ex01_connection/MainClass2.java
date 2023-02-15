package ex01_connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MainClass2 {

	public static Connection getConnection() {
		
		Connection con = null;
		BufferedReader reader =null;
		
	
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties properties = new Properties();
			properties.load(new BufferedReader(new FileReader("db.properties")));
			
			con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	
	}
	

	public static void main(String[] args) {
		
		Connection coo = getConnection();
	}
	
}
