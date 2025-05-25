//BufferedReader reads large files line by line without loading entire file in memory

import java.io.*;
import java.util.Scanner;
public class a8 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter CSV file path: ");
 String filePath = sc.nextLine();
 try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
 String line;
 System.out.println("Processing CSV data:");
 while ((line = br.readLine()) != null) {
 String[] values = line.split(",");
 // Simple processing: print values separated
 for (String val : values) {
 System.out.print(val.trim() + " | ");
 }
 System.out.println();
 }
 } catch (IOException e) {
 System.out.println("Error reading CSV: " + e.getMessage());
 }
 }
}
