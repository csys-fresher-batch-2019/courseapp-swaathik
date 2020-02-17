//package manage.Student;
//
//import com.student.student.StudentDAO;
//import com.student.basics.DAOFactory;
//import com.student.basics.Logger;
//
//import java.util.Scanner;
//
//public class TestStudent2 {
//	private static final Logger LOGGER = Logger.getInstance();
//	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
//		LOGGER.getInput("Enter BatchCode : ");
//		int batchCode = in.nextInt();
//		StudentDAO dao = DAOFactory.getStudentDAO();
//		dao.orderBy(batchCode);
//		in.close();
//
//	}
//
//}
