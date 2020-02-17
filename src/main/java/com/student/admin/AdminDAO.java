package com.student.admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO {
	
	public String login(String adminName, String passWord) throws SQLException;
	
	
}
