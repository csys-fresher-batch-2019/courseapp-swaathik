package com.StudentManagement2.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.StudentManagement2.Basics.Logger;

public class StudentImplements implements StudentDAO {
	private static Logger LOGGER = Logger.getInstance();

	public void addStudents(StudentClass student) throws Exception {
		String sql = "insert into students(adm_no,batch_code,roll_no,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining)values(?,?,?,?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, student.getAdmNo());
		pst.setInt(2, student.getBatchCode());
		pst.setInt(3, student.getRollNo());
		pst.setString(4, student.getFullName());
		pst.setString(5, student.getFatherNameOrGuardianName());
		pst.setString(6, student.getEmailId());
		pst.setString(7, student.getPhoneNo());
		pst.setDate(8, Date.valueOf(student.dateOfJoining));
		//Step 3:Execute the Query
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted : "+rows);
	}

	public void updateStudent(int admNo) throws Exception {
			String sql = "update Students set email_id = 'anusha@gmail.com' where adm_no=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//Step 2: Prepare the Query
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, admNo);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows updated : "+rows);
	}

	public List<StudentClass> orderBy(int batchCode) throws Exception {
			String fullName = null;
	    String sql = "select full_name from students where batch_code=?";
	  //Step 1:Get the Connection
	  		Class.forName("oracle.jdbc.driver.OracleDriver");
	  		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
	  		//Step 2: Prepare the Query
	  		PreparedStatement pst = connection.prepareStatement(sql);
	  		pst.setInt(1, batchCode);
	  		ResultSet rs = pst.executeQuery();
	  		while(rs.next()) {
	  			 fullName = rs.getString("full_name");
	  			LOGGER.debug(fullName);
	  		}
	  		return null;
	  			 
	}

	public void deleteStudent(int admNo) throws Exception {
		String sql = "delete from students where adm_no = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, admNo);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted : "+rows);
		
		
	}
	

}
