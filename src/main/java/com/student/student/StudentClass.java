package com.student.student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.time.LocalDate;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;
public class StudentClass {
	public String getFatherNameOrGuardianName() {
		return fatherNameOrGuardianName;
	}
	private static final Logger LOGGER = Logger.getInstance();
	private int admNo;
	private String fullName;
	private String fatherNameOrGuardianName;
	private String emailId;
	private String phoneNo;
	private String userName;
	private String passWord;
	private LocalDate dateOfJoining;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public int getAdmNo() {
		return admNo;
	}
	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String string() {
		return fatherNameOrGuardianName;
	}
	public void setFatherNameOrGuardianName(String fatherNameOrGuardianName) {
		this.fatherNameOrGuardianName = fatherNameOrGuardianName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate doj) {
		this.dateOfJoining = doj;
	}
	public void setPhoneNo(String phoneNo) {
		if(phoneNo.length()<10 || phoneNo.length()>10)
			throw new IllegalArgumentException("Invalid Phone Number!!!");
		this.phoneNo = phoneNo;
	}
	
	@Override
	public String toString() {
		return "StudentClass [ fullName="
				+ fullName + ", fatherNameOrGuardianName=" + fatherNameOrGuardianName + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", dateOfJoining=" + dateOfJoining + "]";
	}
	public boolean login(StudentClass user) {
		try(Connection con = ConnectionUtil.getConnection();CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1,user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status=stmt.getString(3);
			LOGGER.info("Status = "+status);
			if(status.equals("Success")) {
			LOGGER.debug("Logged In");
			return true;
			}
			else {
			LOGGER.debug("Logged out");
			return false;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}

		return false;
	}
}
