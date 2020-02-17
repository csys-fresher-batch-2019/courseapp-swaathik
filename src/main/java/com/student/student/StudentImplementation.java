package com.student.student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;

public class StudentImplementation implements StudentDAO {
	private static final Logger LOGGER = Logger.getInstance();

	public void addStudents(StudentClass student)  {
		String sql = "insert into students(adm_no,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining,stud_user_name,stud_password)values(adm_no_sq.nextval,?,?,?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, student.getFullName());
			pst.setString(2, student.getFatherNameOrGuardianName());
			pst.setString(3, student.getEmailId());
			pst.setString(4, student.getPhoneNo());
			pst.setDate(5,Date.valueOf(student.getDateOfJoining()));
			pst.setString(6, student.getUserName());
			pst.setString(7, student.getPassWord());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public void updateStudent(int admNo)  {
			String sql = "update Students set email_id = 'anusha@gmail.com' where adm_no=?";
			try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
				pst.setInt(1, admNo);
				int rows = pst.executeUpdate();
				LOGGER.info("No of rows updated : "+rows);
			} catch (Exception e) {
				LOGGER.debug(e);
			}
	}

	

	public void deleteStudent(int admNo)  {
		String sql = "update Students set student_active = 0 where adm_no=?";
		
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, admNo);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
		
	}

	public List<StudentClass> displayStudents() {
		List<StudentClass> c = new ArrayList<>();
		String sql = "select adm_no,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining from students";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				int admNo = rs.getInt("adm_no");
				LOGGER.debug("Admission Number : "+admNo);
				String fullName = rs.getString("full_name");
				LOGGER.debug("Full Name : "+fullName);
				String fatherNameOrGuardianName = rs.getString("father_name_or_guardian_name");
				LOGGER.debug("FatherName Or GuardianName : "+fatherNameOrGuardianName);
				String emailId = rs.getString("email_id");
				LOGGER.debug("Email Id : "+emailId);
				String phoneNo = rs.getString("phone_No");
				LOGGER.debug("Phone Number : "+phoneNo);
				LocalDate dateOfJoining = rs.getDate("date_of_joining").toLocalDate();
				LOGGER.debug("DateOfJoining : "+dateOfJoining);
				
				
				StudentClass student = new StudentClass();
				student.setAdmNo(admNo);
				student.setFullName(fullName);
				student.setFatherNameOrGuardianName(fatherNameOrGuardianName);
				student.setEmailId(emailId);
	            student.setDateOfJoining(dateOfJoining);	
	            student.setPhoneNo(phoneNo);
				c.add(student);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return c;
	}
	

}
