import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running and waiting for a connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Student student = (Student) ois.readObject();

        // Calculate total and percentage
        student.calculate();

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(student);

        oos.close();
        ois.close();
        socket.close();
        serverSocket.close();
    }
}
