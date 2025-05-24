//Implement a Java program to demonstrate constructor chaining.

class ConstructorChain {
 private int a, b, c;

public ConstructorChain() {
 this(10); // calls 1-param constructor
 System.out.println("Default constructor called");
 }

 public ConstructorChain(int a) {
 this(a, 20); // calls 2-param constructor
 System.out.println("One parameter constructor called");
 this.a = a;
 }
public ConstructorChain(int a, int b) {
 this(a, b, 30); // calls 3-param constructor
 System.out.println("Two parameters constructor called");
 this.a = a;
 this.b = b;
}
public ConstructorChain(int a, int b, int c) {
 System.out.println("Three parameters constructor called");
 this.a = a;
 this.b = b;
 this.c = c;
 }
 public void display() {
 System.out.println("a = " + a + ", b = " + b + ", c = " + c);
 }
}
public class a3{
 public static void main(String[] args) {
 ConstructorChain obj = new ConstructorChain();
 obj.display();
 }
}
