//Java Program for Number Guessing Game

import java.util.Scanner;
import java.util.Random;

public class a8{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        int numberToGuess=rand.nextInt(10)+1;

        System.out.println("Guess number between 1-10:");
        int guess=sc.nextInt();

        if(guess==numberToGuess){
            System.out.println("Congratulations! You guessed the number.");
        }else{
            System.out.println("Sorry! The correct number was : "+numberToGuess);
        }
    }
}