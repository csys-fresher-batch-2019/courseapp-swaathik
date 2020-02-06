package manage.Student;

import com.student.student.StudentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

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
