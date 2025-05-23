//Write a Java program that accepts marks for three subjects and calculates the average grade.

import java.util.Scanner;

public class a1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the marks for subject 1");
        int m1=sc.nextInt();
        System.out.println("enter the marks for subject 2");
        int m2=sc.nextInt();
        System.out.println("enter the marks for subject 3");
        int m3=sc.nextInt();

        int total=m1+m2+m3;

        double average=total/3.0;

        System.out.println("The average marks are: " + average);
    }
}