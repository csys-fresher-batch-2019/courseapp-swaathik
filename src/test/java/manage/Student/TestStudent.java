package manage.Student;
import java.time.LocalDate;
import java.util.Scanner;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Student.StudentClass;
import com.StudentManagement2.Student.StudentDAO;

public class TestStudent {
	private static Logger LOGGER = Logger.getInstance();
	public static void main (String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		StudentClass s1 = new StudentClass();
		LOGGER.getInput("Enter Admission No : ");
		s1.setAdmNo(in.nextInt());
		LOGGER.getInput("Enter Batch Code : ");
		s1.setBatchCode(in.nextInt());
		LOGGER.getInput("Enter Roll No : ");
		s1.setRollNo(in.nextInt());
		LOGGER.getInput("Enter Full Name : ");
		s1.setFullName(in.next());
		LOGGER.getInput("Enter Father Name : ");
		s1.setFatherNameOrGuardianName(in.next());
		LOGGER.getInput("Enter email ID");
		s1.setEmailId(in.next());
		LOGGER.getInput("Enter Phone No : ");
		String phone = in.next();
		s1.setPhoneNo(phone);
		LOGGER.getInput("Enter Date Of Joining : ");
		s1.dateOfJoining = LocalDate.parse(in.next());
//		StudentImplements daoImpl2 = new StudentImplements();
//		daoImpl2.addStudents(s1);
		StudentDAO dao = DAOFactory.getStudentDAO();
		dao.addStudents(s1);
		in.close();
		//456	131	42	Sathya	Murali	sathyamurali@gmail.com	9837489490	12-06-08
}
}