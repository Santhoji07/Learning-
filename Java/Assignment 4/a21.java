//A static nested class belongs to the outer class and can be accessed using the outer class name 
//without creating an instance of the outer class

import java.util.Scanner;
class OuterClass {
 static class NestedStaticClass {
 void display() {
 System.out.println("Inside static nested class");
 }
 }
}

public class a21 {
 public static void main(String[] args) {
 // Access static nested class without creating OuterClass object
 OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
 nested.display();
 }
}