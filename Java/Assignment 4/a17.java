//Static methods can be called directly using the class name, without an object.

import java.util.Scanner;

class Math{
    static int square(int x){
        return x * x;
    }
}

public class a17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to square: ");
        int num = sc.nextInt();
        
        // Call the static method using the class name
        int result = Math.square(num);
        
        System.out.println("The square of " + num + " is: " + result);
    }
}