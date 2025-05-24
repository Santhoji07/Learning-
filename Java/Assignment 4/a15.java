//Shows constructor chaining where child constructor calls parent constructor using super.

import java.util.Scanner;
class Employee {
 String name;
 String employeeId;

 Employee(String name, String employeeId) {
 this.name = name;
 this.employeeId = employeeId;
 }
}

class Cashier extends Employee {
 String registerNumber;
 Cashier(String name, String employeeId, String registerNumber) {
 super(name, employeeId);
 this.registerNumber = registerNumber;
 }

void displayDetails() {
 System.out.println("Name: " + name);
 System.out.println("Employee ID: " + employeeId);
 System.out.println("Register Number: " + registerNumber);
 }
}
public class a15{
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter cashier name: ");
 String name = input.nextLine();
 System.out.print("Enter employee ID: ");
 String empId = input.nextLine();
 System.out.print("Enter register number: ");
 String regNum = input.nextLine();
 Cashier cashier = new Cashier(name, empId, regNum);
 cashier.displayDetails();
 }
}