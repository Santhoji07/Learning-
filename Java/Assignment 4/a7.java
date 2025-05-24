//Employee extends Person, adding employeeId and a display method.

import java.util.Scanner;
class Person {
 String name;
 int age;
}
class Employee extends Person {
 String employeeId;

 void displayDetails() {
 System.out.println("Name: " + name);
 System.out.println("Age: " + age);
 System.out.println("Employee ID: " + employeeId);
 }
}
public class a7 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 Employee emp = new Employee();
 System.out.print("Enter name: ");
 emp.name = input.nextLine();
 System.out.print("Enter age: ");
 emp.age = input.nextInt();
 input.nextLine(); // consume newline
 System.out.print("Enter employee ID: ");
 emp.employeeId = input.nextLine();
 emp.displayDetails();
 }
}
