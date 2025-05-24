//Child class overrides method but still calls parent’s version using super.

import java.util.Scanner;

class Animal{
    void makeSound(){
        System.out.println("Amimal makes generic sound");
    }
}
class Dog extends Animal{
    void makeSound(){
        super.makeSound();
        System.out.println("Dog barks");
    }
}

public class a13{
    public static void main(String[]args){
        Dog dog=new Dog();
        dog.makeSound();
    }
}