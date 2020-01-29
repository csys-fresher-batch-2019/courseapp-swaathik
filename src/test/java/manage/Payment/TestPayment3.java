package manage.Payment;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Payment.PaymentDAO;
import java.util.Scanner;

public class TestPayment3  {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter ReceiptNo: ");
		int receiptNo = in.nextInt();
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		dao.deletePayments(receiptNo);
//		PaymentImplements p4 = new PaymentImplements();
//		p4.deletePayments(receiptNo);
	in.close();

	}

}