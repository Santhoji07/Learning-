//Serialization converts an object to bytes to save; deserialization restores it

import java.io.*;
import java.util.Scanner;

class Book implements Serializable{
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class a5{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the file name to save the book details:");
        String fileName = sc.nextLine();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Enter book title:");
            String title = sc.nextLine();
            System.out.println("Enter book author:");
            String author = sc.nextLine();
            System.out.println("Enter book price:");
            double price = sc.nextDouble();

            Book book = new Book(title, author, price);
            oos.writeObject(book);
            System.out.println("Book details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Book book = (Book) ois.readObject();
            System.out.println("Book details read from file:");
            book.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}