package com.StudentManagement2.Student;

import java.time.LocalDate;

public class StudentClass {
	private int admNo;
	private int batchCode;
	private int rollNo;
	private String fullName;
	private String fatherNameOrGuardianName;
	private String emailId;
	private String phoneNo;
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
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void setPhoneNo(String phoneNo) {
		if(phoneNo.length()<10 || phoneNo.length()>10)
			throw new IllegalArgumentException("Invalid Phone Number!!!");
		this.phoneNo = phoneNo;
	}
	public LocalDate dateOfJoining;
	@Override
	public String toString() {
		return "StudentClass [admNo=" + admNo + ", batchCode=" + batchCode + ", rollNo=" + rollNo + ", fullName="
				+ fullName + ", fatherNameOrGuardianName=" + fatherNameOrGuardianName + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", dateOfJoining=" + dateOfJoining + "]";
	}
	

}
