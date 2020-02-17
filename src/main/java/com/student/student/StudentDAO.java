package com.student.student;

import java.util.List;

public interface StudentDAO {
	 void addStudents(StudentClass student) ;
	 
	 void updateStudent(int admNo) ;

	List<StudentClass>displayStudents();
	void deleteStudent(int admNo) ;
	
}
