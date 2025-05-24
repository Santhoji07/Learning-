//Abstract class Vehicle with abstract method start(). Subclasses Car and Bike implement it

import java.util.Scanner;
abstract class Vehicle {
 abstract void start();
}
class Car extends Vehicle {
 void start() {
 System.out.println("Car is starting with a key ignition.");
 }
}
class Bike extends Vehicle {
 void start() {
 System.out.println("Bike is starting with a kick start.");
 }
}

public class a5 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter vehicle type (car/bike): ");
 String type = input.nextLine().toLowerCase();
 Vehicle v;
 if (type.equals("car")) {
 v = new Car();

 } else if (type.equals("bike")) {
 v = new Bike();
 } else {
 System.out.println("Unknown vehicle type.");
 return;
 }
 v.start();
 }
}
