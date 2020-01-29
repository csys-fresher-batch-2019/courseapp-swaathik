package manage.Payment;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Payment.PaymentDAO;

public class TestPayment2 {
	public static void main(String[] args) throws Exception {
//		PaymentImplements p3 = new PaymentImplements();
//		p3.displayAmountPaid();
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		dao.displayAmountPaid();

	}

}
