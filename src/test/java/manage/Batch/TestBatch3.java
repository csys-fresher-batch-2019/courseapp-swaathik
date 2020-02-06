package manage.Batch;

import com.student.basics.DAOFactory;
import com.student.basics.Logger;
import com.student.batch.BatchDAO;

import java.util.Scanner;
public class TestBatch3 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode : ");
		int courseCode = in.nextInt();
		//BatchImplements b3 = new BatchImplements();
		//b3.updateBatches(courseCode);
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.updateBatches(courseCode);
		in.close();
	}

}
