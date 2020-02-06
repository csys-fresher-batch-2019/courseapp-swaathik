package manage.Batch;

import com.student.basics.DAOFactory;
import com.student.basics.Logger;
import com.student.batch.BatchDAO;

import java.util.Scanner;

public class TestBatch2 {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter BatchCode: ");
		int batchCode = in.nextInt();
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.deleteBatches(batchCode);
		in.close();
	}

}
