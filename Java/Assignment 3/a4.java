//Overload constructors with different parameters, assign defaults if needed, and print details

class Vehicle {
 private String model;
 private String manufacturer;
 private String registrationNumber;

 public Vehicle(String model) {
 this.model = model;
 this.manufacturer = "Unknown";
 this.registrationNumber = "Unknown";
 }

 public Vehicle(String model, String manufacturer) {
 this.model = model;
 this.manufacturer = manufacturer;
 this.registrationNumber = "Unknown";
 }

 public Vehicle(String model, String manufacturer, String regNumber) {
 this.model = model;
 this.manufacturer = manufacturer;
 this.registrationNumber = regNumber;
 }

 public void display() {
 System.out.println("Model: " + model);
 System.out.println("Manufacturer: " + manufacturer);
 System.out.println("Registration No: " + registrationNumber);
 System.out.println();
 }
}

public class a4 {
 public static void main(String[] args) {
 Vehicle v1 = new Vehicle("Model A");
 Vehicle v2 = new Vehicle("Model B", "Toyota");
 Vehicle v3 = new Vehicle("Model C", "Honda", "REG1234");
 v1.display();
 v2.display();
 v3.display();
 }
}
