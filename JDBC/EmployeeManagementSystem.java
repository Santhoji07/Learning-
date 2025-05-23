import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/santdb"; // change for SQLite
    static final String USER = "root";
    static final String PASS = "password";

    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            while (true) {
                System.out.println("\n--- Employee Management System ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Generate Employee Report");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: updateEmployee(); break;
                    case 3: generateEmployeeReport(); break;
                    case 4: deleteEmployee(); break;
                    case 5: conn.close(); return;
                    default: System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee() throws SQLException {
        scanner.nextLine(); // consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        double da = 0.1 * salary;
        double hra = 0.2 * salary;
        double net = salary + da + hra;

        String sql = "INSERT INTO employees(name, designation, salary, da, hra, net) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, designation);
        stmt.setDouble(3, salary);
        stmt.setDouble(4, da);
        stmt.setDouble(5, hra);
        stmt.setDouble(6, net);

        int rows = stmt.executeUpdate();
        System.out.println(rows > 0 ? "Employee added successfully." : "Failed to add employee.");
    }

    public static void updateEmployee() throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        double da = 0.1 * salary;
        double hra = 0.2 * salary;
        double net = salary + da + hra;

        String sql = "UPDATE employees SET name=?, designation=?, salary=?, da=?, hra=?, net=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, designation);
        stmt.setDouble(3, salary);
        stmt.setDouble(4, da);
        stmt.setDouble(5, hra);
        stmt.setDouble(6, net);
        stmt.setInt(7, id);

        int rows = stmt.executeUpdate();
        System.out.println(rows > 0 ? "Employee updated successfully." : "Employee not found.");
    }

    public static void generateEmployeeReport() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nID | Name | Designation | Salary | DA | HRA | Net");
        while (rs.next()) {
            System.out.printf("%d | %s | %s | %.2f | %.2f | %.2f | %.2f\n",
                    rs.getInt("id"), rs.getString("name"), rs.getString("designation"),
                    rs.getDouble("salary"), rs.getDouble("da"), rs.getDouble("hra"), rs.getDouble("net"));
        }
    }

    public static void deleteEmployee() throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        String query = "SELECT * FROM employees WHERE id=?";
        PreparedStatement selectStmt = conn.prepareStatement(query);
        selectStmt.setInt(1, id);
        ResultSet rs = selectStmt.executeQuery();

        if (rs.next()) {
            System.out.printf("Record: %s | %s | %.2f\n", rs.getString("name"), rs.getString("designation"), rs.getDouble("salary"));
            System.out.print("Are you sure you want to delete this record? (yes/no): ");
            scanner.nextLine(); // flush
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM employees WHERE id=?");
                deleteStmt.setInt(1, id);
                int rows = deleteStmt.executeUpdate();
                System.out.println(rows > 0 ? "Record deleted successfully." : "Failed to delete.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }
}
