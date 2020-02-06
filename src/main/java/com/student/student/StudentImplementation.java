package com.student.student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;

public class StudentImplementation implements StudentDAO {
	private static Logger LOGGER = Logger.getInstance();

	public void addStudents(StudentClass student) throws Exception {
		String sql = "insert into students(adm_no,batch_code,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining,stud_user_name,stud_password)values(adm_no_sq.nextval,?,?,?,?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, student.getBatchCode());
			pst.setString(2, student.getFullName());
			pst.setString(3, student.getFatherNameOrGuardianName());
			pst.setString(4, student.getEmailId());
			pst.setString(5, student.getPhoneNo());
			pst.setDate(6, Date.valueOf(student.getDateOfJoining()));
			pst.setString(7, student.getUserName());
			pst.setString(8, student.getPassWord());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public void updateStudent(int admNo) throws Exception {
			String sql = "update Students set email_id = 'anusha@gmail.com' where adm_no=?";
			try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
				pst.setInt(1, admNo);
				int rows = pst.executeUpdate();
				LOGGER.info("No of rows updated : "+rows);
			} catch (Exception e) {
				LOGGER.debug(e);
			}
	}

	public List<StudentClass> orderBy(int batchCode) throws Exception {
			String fullName = null;
	    String sql = "select full_name from students where batch_code=?";	
	  		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);ResultSet rs = pst.executeQuery();) {
				pst.setInt(1, batchCode);
				while(rs.next()) {
					 fullName = rs.getString("full_name");
					LOGGER.debug(fullName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	  		return null;
	  			 
	}

	public void deleteStudent(int admNo) throws Exception {
		String sql = "update Students set student_active = 0 where adm_no=?";
		
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, admNo);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
		
	}
	

}
