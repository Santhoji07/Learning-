//Java Program to Find Missing Number in Sequence

import java.util.Scanner;

public class a2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array (n-1): ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int n=size + 1;
        int totalSum=n*(n+1)/2;
        int arrSum=0;

        for(int num:arr){
            arrSum+=num;
        }

        int missing=totalSum-arrSum;
        System.out.println("The missing number is: "+missing);
    }
}