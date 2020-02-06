package com.student.student;

public interface StudentDAO {
	 void addStudents(StudentClass student) ;
	 
	 void updateStudent(int admNo) ;
	 
	//select fullName from students order by batch_code
	String orderBy(int batchCode) ;
	
	void deleteStudent(int admNo) ;
	
}
