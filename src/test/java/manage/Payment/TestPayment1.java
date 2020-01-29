package manage.Payment;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Payment.PaymentDAO;
import java.util.Scanner;

public class TestPayment1 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Receipt No : ");
		int receiptNo = in.nextInt();
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		dao.updatePayments(receiptNo);
//		PaymentImplements p2 = new PaymentImplements();
//		p2.updatePayments(receiptNo);
		in.close();
		

	}

}
