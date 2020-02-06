package com.student.student;
import java.util.List;
public interface StudentDAO {
	 void addStudents(StudentClass student) ;
	 
	 void updateStudent(int admNo) ;
	 
	//select fullName from students order by batch_code
	List<StudentClass>orderBy(int batchCode) ;
	
	void deleteStudent(int admNo) ;
	
}
