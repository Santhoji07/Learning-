//Use BufferedReader/Writer for text and FileInput/OutputStream for binary copy

import java.io.*;
import java.util.Scanner;  

public class a7 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter text file to copy: ");
 String textFile = sc.nextLine();
 System.out.print("Enter destination text file: ");
 String destTextFile = sc.nextLine();
 try (BufferedReader br = new BufferedReader(new FileReader(textFile));
 BufferedWriter bw = new BufferedWriter(new FileWriter(destTextFile))) {
 String line;
 while ((line = br.readLine()) != null) {
 bw.write(line);
 bw.newLine();
 }
 System.out.println("Text file copied.");
 } catch (IOException e) {
 System.out.println("Error copying text file: " + e.getMessage());

 }
 System.out.print("Enter binary file to copy: ");
 String binaryFile = sc.nextLine();
 System.out.print("Enter destination binary file: ");
 String destBinaryFile = sc.nextLine();
 try (FileInputStream fis = new FileInputStream(binaryFile);
 FileOutputStream fos = new FileOutputStream(destBinaryFile)) {
 int b;
 while ((b = fis.read()) != -1) {
 fos.write(b);
 }
 System.out.println("Binary file copied.");
 } catch (IOException e) {
 System.out.println("Error copying binary file: " + e.getMessage());
 }
 }
}
