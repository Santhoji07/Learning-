//BufferedReader reads text line-by-line efficiently; BufferedWriter writes lines to file

import java.io.*;
import java.util.Scanner;

public class a3{
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter input file path: ");
 String inputFile = sc.nextLine();
 System.out.print("Enter output file path: ");
 String outputFile = sc.nextLine();
 try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
 BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
 String line;
 while ((line = br.readLine()) != null) {
 bw.write(line);
 bw.newLine();
 }
 System.out.println("File copied line by line.");
 } catch (IOException e) {
 System.out.println("Error: " + e.getMessage());
 }
 }
}
