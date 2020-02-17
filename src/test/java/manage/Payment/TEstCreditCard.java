package manage.Payment;

import java.time.LocalDate;

import creditcard.CreditCardService;

public class TEstCreditCard {

public static void main(String[] args) {
creditcard.CreditCard creditCard=new creditcard.CreditCard();
creditCard.setCardNo(1111111111111111L);
creditCard.setExpiryDate(LocalDate.parse("2020-09-08"));
creditCard.setCvvNo(123);
//	creditCard.setPin(1234);
try {
String id="courseApp";
boolean status=CreditCardService.pay(creditCard,1000.244f,id);
System.out.println(status);
} catch (Exception e) {
e.printStackTrace();
}

}

}

