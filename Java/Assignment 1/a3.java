//Java Program to Calculate Electricity Bill

import java.util.Scanner;

public class a3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of units consumed:");
        int units=sc.nextInt();

        int ratePerUnit =5;

        double billAmount=units*ratePerUnit;
        System.out.println("The total electricity bill is: " + billAmount);
    }
}