//A static variable is shared by all instances. We use it to keep track of how many objects have been 
//created

import java.util.Scanner;

class Counter{
    static int count=0;

    Counter(){
        count++;
    }

    static void displayCount(){
        System.out.println("Total objects created: " + count);
    }
}

public class a16{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of objects to create: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            new Counter();
        }
        Counter.displayCount();

    }
}