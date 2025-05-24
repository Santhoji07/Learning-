//Demonstrate runtime polymorphism using overridden draw() methods and a base class reference

import java.util.Scanner;

class Shape{
    void draw(){
        System.out.println("Drawing a shape");
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("Drawing a circle");
    }
}
class Rectangle extends Shape{
    void draw(){
        System.out.println("Drawing a rectangle");
    }
}

public class a9{
    public static void main(String args[]){
        Shape s;

        s=new Circle();
        s.draw();

        s=new Rectangle();
        s.draw();

    }
}