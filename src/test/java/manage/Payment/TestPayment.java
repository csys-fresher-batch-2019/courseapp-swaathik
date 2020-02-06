package manage.Payment;
import java.time.LocalDate;
import java.util.Scanner;

import com.student.payment.PaymentClass;
import com.student.payment.PaymentDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;
public class TestPayment {
	private static Logger LOGGER = Logger.getInstance();
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
		//call dao
//		PaymentImplements daoimpl3 = new PaymentImplements();
//		daoimpl3.addPayments(p1);
		 PaymentDAO dao = DAOFactory.getPaymentDAO();
			dao.addPayments(p1);
		in.close();
//10	120	10000	11-06-19	Cash
	}

}
