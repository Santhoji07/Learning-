//We catch standard exceptions and create a custom exception to check if file is empty.

import java.io.*;
import java.util.Scanner;

class EmptyFileException extends Excepption{
    EmptyFileException(String message){
        super(message);
    }
}

public class a6{
    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter file path to read: ");
 String path = sc.nextLine();

 try(BufferedReader br = new BufferedReader(new FileReader(path)))
 if(br.readLine()==null){
    throw new EmptyFileException("File is empty");
 }
br.close();

BufferedReader br2 = new BufferedReader(new FileReader(path));
 String line;
 while((line = br.readLine()) != null){
     System.out.println(line);
 }
 br2.close();
 } catch (FileNotFoundException e) {
     System.out.println("File not found: " + e.getMessage());
 } catch (IOException e) {
     System.out.println("I/O error: " + e.getMessage());
 } catch (EmptyFileException e) {
     System.out.println(e.getMessage());
 } catch (Exception e) {
     System.out.println("An unexpected error occurred: " + e.getMessage());
 }
    }
