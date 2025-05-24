//Use StringBuilder’s reverse() method to reverse the input string

import java.util.Scanner;

public class a1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String str=sc.nextLine();

        StringBuilder sb=new StringBuilder(str);
        String reversed= sb.reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }
}