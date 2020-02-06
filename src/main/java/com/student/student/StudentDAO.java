package com.student.student;
import java.util.List;
public interface StudentDAO {
	 void addStudents(StudentClass student) throws Exception;
	 
	 void updateStudent(int admNo) throws Exception;
	 
	//select fullName from students order by batch_code
	List<StudentClass>orderBy(int batchCode) throws Exception;
	
	void deleteStudent(int admNo) throws Exception;
	
}
