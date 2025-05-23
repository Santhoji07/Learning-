//Java Program to Calculate Discounted Price

import java.util.Scanner;
public class a6{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the original price of the item:");
        double originalPrice=sc.nextDouble();
        System.out.println("Enter the discount percentage:");
        double discountPercentage=sc.nextDouble();

        double discountPrice=originalPrice-(originalPrice*discountPercentage/100);
        System.out.println("The price after discount is: " + discountPrice);
    }
}