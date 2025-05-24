//Write a Java program to create a class called "Circle" with a radius attribute. You can access and 
//modify this attribute. Calculate the area and circumference of the circle.

import java.util.Scanner;

class Circle{
   private double radius;

   public Circle(double radius){
    this.radius=radius;
   }

   public double getRadius(){
    return radius;
   }

   public void setRadius(double radius){
    this.radius=radius;
   }
   public double getArea(){
    return Math.PI * radius * radius;
   }
    public double getCircumference(){
     return 2 * Math.PI * radius;
    }
}

public class a1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();
        
        Circle circle = new Circle(radius);
        
        System.out.println("Area of the circle: " + circle.getArea());
        System.out.println("Circumference of the circle: " + circle.getCircumference());
    }
}