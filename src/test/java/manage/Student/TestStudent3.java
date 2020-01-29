package manage.Student;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Student.StudentDAO;
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
