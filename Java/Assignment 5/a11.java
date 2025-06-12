//Divide by zero causes ArithmeticException; handle it to avoid program crash.

import java.util.Scanner;
public class a11 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter numerator: ");
 int num = sc.nextInt();
 System.out.print("Enter denominator: ");
 int denom = sc.nextInt();
 try {
 int result = num / denom;
 System.out.println("Result: " + result);
 } catch (ArithmeticException e) {
 System.out.println("Error: Division by zero is not allowed.");
 }
 }
88
}
