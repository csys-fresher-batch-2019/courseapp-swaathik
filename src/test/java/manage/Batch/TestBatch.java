package manage.Batch;

import java.time.LocalDate;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Batch.BatchClass;
import com.StudentManagement2.Batch.BatchDAO;

import java.util.Scanner;
public class TestBatch {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		//input
		BatchClass b1 = new BatchClass();
		Scanner in = new Scanner(System.in);
	   LOGGER.getInput("Enter BatchCode : ");
		int a = in.nextInt();
		b1.setBatchCode(a);
		LOGGER.getInput("Enter CourseCode : ");
		int b = in.nextInt();
		b1.setCourseCode(b);
		LOGGER.getInput("Enter CourseName : ");
	    String f = in.next();
		b1.setCourseName(f);
		LOGGER.getInput("Enter StartingDate : ");
		LocalDate c = LocalDate.parse(in.next());
		b1.setStartingDate(c);
		LOGGER.getInput("Enter EndDate : ");
	    LocalDate d = LocalDate.parse(in.next());
	    b1.setEndDate(d);
		//call dao
		//BatchImplements daoImpl = new BatchImplements();
		//daoImpl.addBatches(b1);
	    BatchDAO dao = DAOFactory.getBatchDAO();
		dao.addBatches(b1);
		in.close();

	}
	

}
