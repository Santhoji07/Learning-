//Java Program to Convert USD to INR

import java.util.Scanner;
public class a4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount in USD:");
        double usd=sc.nextDouble();
        double conversionRate=74.85; // Example conversion rate
        double inr=usd*conversionRate;
        System.out.println("The amount in INR is: " + inr);
    }
}