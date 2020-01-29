package manage.Student;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Student.StudentDAO;
import java.util.Scanner;

public class TestStudent2 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter BatchCode : ");
		int batchCode = in.nextInt();
//		StudentImplements s3 = new StudentImplements();
//		s3.orderBy(batchCode);
		StudentDAO dao = DAOFactory.getStudentDAO();
		dao.orderBy(batchCode);
		in.close();

	}

}
