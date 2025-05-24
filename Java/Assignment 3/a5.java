//Use a constructor to read user input (Scanner) and set attributes. Display book details.

import java.util.Scanner;

class Book {
 private String title;
 private String author;
 private double price;

 public Book() {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter book title: ");
 title = input.nextLine();
 System.out.print("Enter author name: ");
 author = input.nextLine();
 System.out.print("Enter price: ");
 price = input.nextDouble();
 }

 public void display() {
 System.out.println("\nBook Details:");
 System.out.println("Title: " + title);
 System.out.println("Author: " + author);
 System.out.println("Price: ₹" + price);
 }
}

public class a5 {
 public static void main(String[] args) {
 Book book = new Book();
 book.display();
 }
}