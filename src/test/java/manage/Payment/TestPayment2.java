package manage.Payment;

import com.student.payment.PaymentDAO;
import com.student.basics.DAOFactory;

public class TestPayment2 {
	public static void main(String[] args) throws Exception {
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		dao.displayAmountPaid();

	}

}
