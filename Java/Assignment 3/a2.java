//Write a Java program to create class called "TrafficLight" with attributes for color and duration, and 
//methods to change the color and check for red or green

import java.util.Scanner;

class TrafficLight {

 private String color;
 private int duration;

 public TrafficLight(String color, int duration) {
 this.color = color;
 this.duration = duration;
 }
 public void changeColor(String newColor) {
 this.color = newColor;
 }
 public boolean isRed() {
 return color.equalsIgnoreCase("red");
 }
 public boolean isGreen() {
 return color.equalsIgnoreCase("green");
 }
 public String getColor() {
 return color;
 }
}

public class a2 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter initial color: ");
 String color = input.next();
 System.out.print("Enter duration in seconds: ");
 int duration = input.nextInt();
 TrafficLight light = new TrafficLight(color, duration);
 System.out.print("Enter new color to change to: ");
 String newColor = input.next();
 light.changeColor(newColor);
 System.out.println("Current Color: " + light.getColor());
 if (light.isRed()) {
 System.out.println("STOP!");
 } else if (light.isGreen()) {
 System.out.println("GO!");
 } else {
 System.out.println("WAIT!");
 }
 }
}