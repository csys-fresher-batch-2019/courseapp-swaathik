package manage.Student;

import com.student.student.StudentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

import java.util.Scanner;

public class TestStudent1 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Admission No : ");
		int admNo = in.nextInt();
//		StudentImplements s2 = new StudentImplements();
//		s2.updateStudent(admNo);
		StudentDAO dao = DAOFactory.getStudentDAO();
		dao.updateStudent(admNo);
		in.close();

	}

}
