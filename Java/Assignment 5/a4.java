//DataOutputStream writes primitive data types in binary format; DataInputStream reads them back.

import java.io.*;
import java.util.Scanner;

public class a4{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String fileName="student.txt";

        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName))){
            System.out.print("Enter student name: ");
 String name = sc.nextLine();
 System.out.print("Enter student age: ");
 int age = sc.nextInt();
 System.out.print("Enter student grade: ");
 sc.nextLine();
 String grade = sc.nextLine();
 dos.writeUTF(name);
 dos.writeInt(age);
 dos.writeUTF(grade);
 System.out.println("Student details saved.");
 } catch (IOException e) {
 System.out.println("Error writing data: " + e.getMessage());
    }
    try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
 String name = dis.readUTF();
 int age = dis.readInt();
 String grade = dis.readUTF();
 System.out.println("Student Details:");
 System.out.println("Name: " + name);
 System.out.println("Age: " + age);
 System.out.println("Grade: " + grade);
 } catch (IOException e) {
 System.out.println("Error reading data: " + e.getMessage());
 }
 }

   }