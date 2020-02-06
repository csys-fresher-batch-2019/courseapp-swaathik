package manage.Course;
import java.util.Scanner;

import com.student.client.WalletAPI;
	public class TestWallet {


		public static void main(String[] args) {

			Long studentMobileNo = 9999999999L;
			int amount = 1000;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter mobile no: ");
			System.out.println("Enter pin");
			int pinNumber = 1234;
			WalletAPI.pay(studentMobileNo,  pinNumber, amount);
			sc.close();
		}

}
