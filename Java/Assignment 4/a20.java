//Static methods are inherited but are called using class names (not objects).

class Parent {
 static void display() {
 System.out.println("Static method in Parent class");
 }
}
class Child extends Parent {
 // Child inherits static method display()
}
public class a20 {
 public static void main(String[] args) {
 Parent.display(); // Call using parent class name
 Child.display(); // Call using child class name
 }
}
