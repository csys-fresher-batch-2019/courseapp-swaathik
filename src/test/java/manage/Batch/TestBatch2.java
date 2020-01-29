package manage.Batch;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Batch.BatchDAO;
import java.util.Scanner;

public class TestBatch2 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter BatchCode: ");
		int batchCode = in.nextInt();
		//BatchImplements b2 = new BatchImplements();
		//b2.deleteBatches(batchCode);
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.deleteBatches(batchCode);
		in.close();
	}

}
