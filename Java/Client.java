import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int roll = scanner.nextInt();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        Student student = new Student(name, roll, marks);

        Socket socket = new Socket("localhost", 1234);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(student);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Student resultStudent = (Student) ois.readObject();

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + resultStudent.getName());
        System.out.println("Roll No: " + resultStudent.getRollNo());
        System.out.println("Marks: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + resultStudent.getMarks()[i]);
        }
        System.out.println("Total: " + resultStudent.getTotal());
        System.out.println("Percentage: " + resultStudent.getPercentage());

        ois.close();
        oos.close();
        socket.close();
    }
}
