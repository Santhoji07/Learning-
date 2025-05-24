//Traverse each character, check if it’s a vowel or consonant, and count accordingly.

import java.util.Scanner;

public class a2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();

        int vowelCount=0; 
        int consonantsCount=0;

        for (int i=0; i<str.length(); i++){
            char ch=str.charAt(i);

            if(ch>='a' && ch<='z'){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowelCount++;
                } else {
                    consonantsCount++;
                }
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantsCount);
    }
}