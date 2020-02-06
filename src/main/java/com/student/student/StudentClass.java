package com.student.student;

import java.time.LocalDate;

public class StudentClass {
	private int admNo;
	private int batchCode;
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
	public int getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(int batchCode) {
		this.batchCode = batchCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFatherNameOrGuardianName() {
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
		return "StudentClass [batchCode=" + batchCode + ",  fullName="
				+ fullName + ", fatherNameOrGuardianName=" + fatherNameOrGuardianName + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", dateOfJoining=" + dateOfJoining + "]";
	}
	

}
