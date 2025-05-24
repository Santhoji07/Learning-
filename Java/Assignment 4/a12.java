//Base class Loan has a method to get interest rate. Derived classes override it. Base class reference 
//used to call the correct method dynamically.

import java.util.Scanner;
class Loan {
 double getInterestRate() {
 return 0.0;
 }
}
class HomeLoan extends Loan {
 double getInterestRate() {
 return 7.5;
 }
}
class CarLoan extends Loan {
 double getInterestRate() {
 return 9.0;
 }
}
public class a12{
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter loan type (home/car): ");
 String type = input.nextLine().toLowerCase();
 Loan loan;
 if (type.equals("home")) {
 loan = new HomeLoan();
 } else if (type.equals("car")) {
 loan = new CarLoan();
 } else {
 System.out.println("Invalid loan type");
 return;
 }
 System.out.println("Interest rate: " + loan.getInterestRate() + "%");
 }
}

