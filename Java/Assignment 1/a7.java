//Java Program to Calculate Simple Interest

import java.util.Scanner;
public class a7 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.println("Enter principal amount: ");
 double principal = input.nextDouble();
 System.out.println("Enter rate of interest: ");
 double rate = input.nextDouble();
 System.out.println("Enter time in years: ");
 double time = input.nextDouble();
 double interest = (principal * rate * time) / 100;
 System.out.println("Simple Interest: ₹" + interest);
 }
}
