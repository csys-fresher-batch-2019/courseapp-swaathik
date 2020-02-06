package manage.Student;
import java.time.LocalDate;
import java.util.Scanner;

import com.student.student.StudentClass;
import com.student.student.StudentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

public class TestStudent {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main (String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		StudentClass s1 = new StudentClass();
		LOGGER.getInput("Enter Batch Code : ");
		s1.setBatchCode(in.nextInt());
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
		s1.setDateOfJoining(LocalDate.parse(in.next()));
		LOGGER.getInput("Enter the username : (for login)");
		s1.setUserName(in.next());
		LOGGER.getInput("Enter the password : (for login)");
		s1.setPassWord(in.next());
		StudentDAO dao = DAOFactory.getStudentDAO();
		dao.addStudents(s1);
		in.close();
}
}