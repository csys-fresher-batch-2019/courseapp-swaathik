package manage.Student;
import java.time.LocalDate;
import java.util.Scanner;

import com.student.basics.DAOFactory;


import com.student.student.StudentDAO;
public class TestStudent4 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentDAO  dao = DAOFactory.getStudentDAO();
		dao.displayStudents();
		in.close();
		
		
		

	}

}
