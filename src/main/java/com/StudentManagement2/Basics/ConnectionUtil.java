package com.StudentManagement2.Basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	public static  Connection getConnection() throws ClassNotFoundException,SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String server = "CSLH2024";
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE","system","oracle");
		return connection;
		
	}
}