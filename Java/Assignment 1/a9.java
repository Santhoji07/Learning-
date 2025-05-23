//Java Program to Check Palindrome String

import java.util.Scanner;
public class a9{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();

        String reversed=new StringBuilder(str).reverse().toString();

        if(str.equals(reversed)){
            System.out.println(str + " is a palindrome.");
        }else{
            System.out.println(str + " is not a palindrome.");
        }
    }
}