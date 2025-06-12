//Java Program to Calculate Income Tax Based on Slabs

import java.util.Scanner;
public class a5 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter your salary: ");
 double salary = input.nextDouble();
 double tax = 0;
 if (salary <= 250000) {
 tax = 0;
 } else if (salary <= 500000) {
 tax = (salary - 250000) * 0.05;
 } else if (salary <= 1000000) {
 tax = (250000 * 0.05) + (salary - 500000) * 0.20;
 } else {
 tax = (250000 * 0.05) + (500000 * 0.20) + (salary - 1000000) * 0.30;
 }
 System.out.println("Income Tax to be paid: ₹" + tax);
 }
}

