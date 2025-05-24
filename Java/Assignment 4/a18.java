//Static blocks execute once when the class is loaded, before the main() method.

public class a18 {
 static {
 System.out.println("Static block executed before main method.");
 }
 public static void main(String[] args) {
 System.out.println("Main method executed.");
 }
}
