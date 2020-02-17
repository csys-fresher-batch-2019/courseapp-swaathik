package manage.Course;
//import com.student.client.WalletAPI;
import com.student.course.CourseDAO;
import creditcard.CreditCardService;
import creditcard.PaymentResponse;

import com.student.basics.DAOFactory;
import com.student.basics.Logger;
import java.time.LocalDate;
import java.util.Scanner;
public class TestCourse4 {
private static Logger LOGGER = Logger.getInstance();
public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode : ");
		int courseCode = in.nextInt();
		CourseDAO dao  = DAOFactory.getCourseDAO();
		int fees = dao.getCourseFee(courseCode);
		creditcard.CreditCard creditCard=new creditcard.CreditCard();		
		System.out.println("Enter CreditCardNumber no: ");
		creditCard.setCardNo(in.nextLong());
		System.out.println("Enter CVV Number : ");
		creditCard.setCvvNo(in.nextInt());
		System.out.println("Enter Expiry Date : ");
		LocalDate g = LocalDate.parse(in.next());
		System.out.println("Enter Pin Number : ");
		creditCard.setPin(in.nextInt());
		creditCard.setExpiryDate(g);
		String id="courseApp";
		System.out.println(creditCard.getCardNo() + "-" + creditCard.getExpiryDate() + "-" + creditCard.getCvvNo());
		System.out.println(fees + "-" + id);
		PaymentResponse status=CreditCardService.pay(creditCard,fees,id, id);
		System.out.println(status);
		in.close();

	}

}
