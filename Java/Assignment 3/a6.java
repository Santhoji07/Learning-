//Use method overloading: one method with name & app no., another with name, app no. & exam 
//center. Use this keyword.

class Candidate {
 private String name;
 private String applicationNumber;
 private String examCenter;
 public void registerCandidate(String name, String applicationNumber) {
 this.name = name;
 this.applicationNumber = applicationNumber;
 this.examCenter = "Not assigned";
 }
 public void registerCandidate(String name, String applicationNumber, String examCenter) {
 this.name = name;
 this.applicationNumber = applicationNumber;
 this.examCenter = examCenter;
 }
 public void display() {
 System.out.println("Name: " + name);
 System.out.println("Application No: " + applicationNumber);
 System.out.println("Exam Center: " + examCenter);
 System.out.println();
 }
}
public class a6 {

 public static void main(String[] args) {
 Candidate c1 = new Candidate();
 c1.registerCandidate("Alice", "APP001");
 Candidate c2 = new Candidate();
 c2.registerCandidate("Bob", "APP002", "Center A");
 c1.display();
 c2.display();
 }
}