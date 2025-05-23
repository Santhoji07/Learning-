//Java Program to Find All Pairs with Given Sum

import java.util.Scanner;

public class a3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size=input.nextInt();

        int arr[]=new int[size];
        System.out.println("Enter " + size + " elements of the array:");
        for(int i=0;i<size;i++){
            arr[i]=input.nextInt();
        }

        int target=9;

        System.out.println("Pairs with sum " + target + ":");
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("("+arr[i]+", "+arr[j]+")");
                }
            }
        }
    }
}