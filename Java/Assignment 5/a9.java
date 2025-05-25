//Write a program to implement a simple text editor where users can create, edit, and read files using 
//Scanner, FileWriter, and BufferedReader.

import java.io.*;
import java.util.Scanner;
public class a9{
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter file name to create/edit: ");
 String fileName = sc.nextLine();
 try (FileWriter fw = new FileWriter(fileName)) {
 System.out.println("Enter text (type 'exit' in new line to finish):");
 while (true) {
 String line = sc.nextLine();
 if (line.equalsIgnoreCase("exit"))
 break;
 fw.write(line + "\n");
 }
 } catch (IOException e) {
 System.out.println("Error writing file: " + e.getMessage());
 }
 System.out.println("File contents:");
 try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
 String line;
 while ((line = br.readLine()) != null)
 System.out.println(line);
 } catch (IOException e) {
 System.out.println("Error reading file: " + e.getMessage());
 }
 }
}