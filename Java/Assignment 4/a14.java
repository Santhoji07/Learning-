//Demonstrates variable shadowing and how to access the parent class variable using super.

import java.util.Scanner;

class Person {
 String name = "Parent Name";
}

class Employee extends Person {
 String name = "Child Name";
 void display(){
    System.out.println("Parent name:"+super.name);
    System.out.println("Child name:"+name);
 }
}
public class a14{
    public static void main(String args[]){
        Employee e=new Employee();
        e.display();
    }
}