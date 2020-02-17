package com.student.basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
public class ConnectionUtil {
	private static final Logger LOGGER = Logger.getInstance();
	private ConnectionUtil() {
	    throw new IllegalStateException("Utility class");
	  }

	public static  Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LOGGER.debug(e);
		}
		
		String server = "CSLH2024";
		return (DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE","system","oracle"));
		
	}
	public static Jdbi getJdbi() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}
}