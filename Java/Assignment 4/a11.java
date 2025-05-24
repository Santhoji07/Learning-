//Base class Animal defines makeSound(). Derived classes override this to provide specific sounds. A 
//base class reference calls the appropriate method at runtime.

import java.util.Scanner;

class Animal {
 void makeSound() {
 System.out.println("Animal makes a sound");
 }
}
class Dog extends Animal {
 void makeSound() {
 System.out.println("Dog barks");
 }
}
class Cat extends Animal {
 void makeSound() {
 System.out.println("Cat meows");
 }
}

public class a11{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter animal type(Dog/Cat):");
        String type=sc.nextLine().toLowerCase();

        Animal a;

        if(type.equals("dog")){
            a=new Dog();
        }else if(type.equals("cat")){
            a=new Cat();
        }else{
            System.out.println("Unknown animal");
            return;
        }
        a.makeSound();
    }
}

