//We use FileInputStream to read bytes from the source file and FileOutputStream to write those 
//bytes to the destination file. This program copies the entire file byte-by-byte.

import java.io.*;
import java.util.Scanner;

public class a1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the source file name:");
        String sourcePath = sc.nextLine();
        System.out.println("Enter the destination file name:");
        String destPath = sc.nextLine();

        try(FileInputStream fis=new FileInputStream(sourcePath);
        FileOutputStream fos=new FileOutputStream(destPath)){

        int byteRead;

        while((byteRead=fis.read())!=-1){
            fos.write(byteRead);
        }
        System.out.println("File copied successfully.");
    }catch(FileNotFoundException e){
        System.out.println("Source file not found:" +e.getMessage());
    }catch(IOException e){
        System.out.println("Error occurred while copying file:" +e.getMessage());
}
    }
    }