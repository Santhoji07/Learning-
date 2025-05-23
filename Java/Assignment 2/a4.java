// Java Program to Simulate Traffic Light System

import java.util.Scanner;
public class a4 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter Traffic Light Color (Red, Yellow, Green): ");
 String color = input.next();
 switch(color.toLowerCase()) {
 case "red":
 System.out.println("STOP! Wait until the light turns green.");
 break;
 case "yellow":
 System.out.println("GET READY! The light is about to turn green.");
 break;
 case "green":
 System.out.println("GO! You can proceed.");
 break;
 default:
 System.out.println("Invalid color entered.");
 }
 }
}