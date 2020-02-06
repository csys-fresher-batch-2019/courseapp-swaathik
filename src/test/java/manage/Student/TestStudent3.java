package manage.Student;

import com.student.student.StudentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

import java.util.Scanner;

public class TestStudent3 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Admission No : ");
		int admNo = in.nextInt();
		StudentDAO dao = DAOFactory.getStudentDAO();
		dao.deleteStudent(admNo);
//		StudentImplements s4 = new StudentImplements();
//		s4.deleteStudent(admNo);
		in.close();
		
	}

}
