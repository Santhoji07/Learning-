//Write a program to read and write character data using FileReader and FileWriter

import java.io.*;
import java.util.Scanner;
public class a2 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter input file path: ");
 String inputFile = sc.nextLine();
 System.out.print("Enter output file path: ");
 String outputFile = sc.nextLine();
 try (FileReader fr = new FileReader(inputFile);
 FileWriter fw = new FileWriter(outputFile)) {
 int ch;
 while ((ch = fr.read()) != -1) {
 fw.write(ch);
 }
 System.out.println("File copied using FileReader and FileWriter.");
 } catch (IOException e) {
 System.out.println("Error: " + e.getMessage());
 }
 }
}
