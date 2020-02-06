package manage.Payment;
import java.time.LocalDate;
import java.util.Scanner;

import com.student.payment.PaymentClass;
import com.student.payment.PaymentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;
public class TestPayment {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		PaymentClass p1 = new PaymentClass();
		LOGGER.getInput("Enter Admission No : ");
		p1.setAdmNo(in.nextInt());
		LOGGER.getInput("Enter Amount Paid : ");
		p1.setAmountPaid(in.nextInt());
		LOGGER.getInput("Enter payDate : ");
		p1.setPayDate(LocalDate.parse(in.next()));
		LOGGER.getInput("Enter remarks (Cheque/Cash) : ");
		p1.setReMarks(in.next());
		 PaymentDAO dao = DAOFactory.getPaymentDAO();
			dao.addPayments(p1);
		in.close();
	}

}
