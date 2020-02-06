package com.student.basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	private ConnectionUtil() {
	    throw new IllegalStateException("Utility class");
	  }

	public static  Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String server = "CSLH2024";
		return (DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE","system","oracle"));
		
	}
}