package com.student.basics;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.student.student.StudentClass;


public class UserService {
	private UserService() {
	    throw new IllegalStateException("Utility class");
	  }
	public static boolean login(StudentClass user) throws ClassNotFoundException, SQLException {
		try(Connection con = ConnectionUtil.getConnection();CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}");) {
			stmt.setString(1,user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status=stmt.getString(3);
			if(status.equals("Success")) {

			Logger.log("Logged In");
			return true;
			}
			else {
			Logger.log("Logged out");
			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

		}
		}

