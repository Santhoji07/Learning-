//Abstract class Shape defines area(); Circle and Rectangle override it

import java.util.Scanner;

abstract class Shape{
    abstract double area();
}

class Circle extends Shape{
    double radius;

    Circle(double r){
        radius =r;
    }

    double area(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    double length, width;

    Rectangle(double l, double w){
        length=l;
        width=w;
    }

    double area(){
        return length * width;
    }
}

public class  a4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of Circle: ");
        double r= sc.nextDouble();
        Circle c= new Circle(r);

    System.out.println("Area of Circle: " + c.area());

        System.out.print("Enter length and width of Rectangle: ");
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        Rectangle rect = new Rectangle(l, w);

        System.out.println("Area of Rectangle: " + rect.area());
    }
}
