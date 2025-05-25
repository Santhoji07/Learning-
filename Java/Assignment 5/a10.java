//User data is serialized to file and deserialized to check login credentials.
import java.io.*;
import java.util.Scanner;
class User implements Serializable {
 String username;
 String password;
 User(String u, String p) {
 username = u;
 password = p;
 }
}
public class a10 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 String fileName = "users.ser";
 // Register user
 System.out.print("Enter new username to register: ");
 String user = sc.nextLine();
 System.out.print("Enter new password: ");
 String pass = sc.nextLine();

 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
 oos.writeObject(new User(user, pass));
 System.out.println("User registered.");
 } catch (IOException e) {
 System.out.println("Error saving user: " + e.getMessage());
 }
 // Login
 System.out.print("Enter username to login: ");
 String loginUser = sc.nextLine();
 System.out.print("Enter password: ");
 String loginPass = sc.nextLine();
 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
 User u = (User) ois.readObject();
 if (u.username.equals(loginUser) && u.password.equals(loginPass)) {
 System.out.println("Login successful.");
 } else {
 System.out.println("Invalid username or password.");
 }
 } catch (IOException | ClassNotFoundException e) {
 System.out.println("Error reading user data: " + e.getMessage());
 }
 }
}
