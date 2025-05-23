//Java Program to Calculate Body Mass Index (BMI)
import java.util.Scanner;

public class a2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your weight in kilograms:");
        double weight=sc.nextDouble();
        System.out.println("Enter your height in meters:");
        double height=sc.nextDouble();

        double bmi=weight/(height*height);
        System.out.println("Your Body Mass Index (BMI) is: " + bmi);

    }
}