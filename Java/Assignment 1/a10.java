//Java Program to Calculate Book Fine

import java.util.Scanner;

public class a10 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter number of days late: ");
 int daysLate = input.nextInt();
 int finePerDay = 10;
 int totalFine = daysLate * finePerDay;
 System.out.println("Total Fine: ₹" + totalFine);
 }
}