//Base class Payment with method processPayment(). Subclasses override it. A parent class reference 
//calls the correct method at runtime.

import java.util.Scanner;

class Payment {
    void processPayment() {
        System.out.println("Processing payment in base class.");
    }
}
class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Processing credit card payment.");
    }
}
class PayPalPayment extends Payment {
    void processPayment() {
        System.out.println("Processing PayPal payment.");
    }
}

public class a10{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter payment method (creditcard/paypal): ");
        String method = input.nextLine().toLowerCase();
        
        Payment payment;
        
        if (method.equals("creditcard")) {
            payment = new CreditCardPayment();
        } else if (method.equals("paypal")) {
            payment = new PayPalPayment();
        } else {
            System.out.println("Unknown payment method.");
            return;
        }
        
        payment.processPayment();
    }
}