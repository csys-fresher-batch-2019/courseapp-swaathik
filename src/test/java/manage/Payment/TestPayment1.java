package manage.Payment;

import com.student.payment.PaymentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

import java.util.Scanner;

public class TestPayment1 {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Receipt No : ");
		int receiptNo = in.nextInt();
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		dao.updatePayments(receiptNo);
		in.close();
		

	}

}
