//Abstract class BankAccount defines an abstract method accountType(). Both subclasses implement 
//this method to specify account type.

import java.util.Scanner;

abstract class BankAccount {
 abstract void accountType();
}
class SavingsAccount extends BankAccount {
 void accountType() {
 System.out.println("This is a Savings Account.");
 }
}
class CurrentAccount extends BankAccount {
 void accountType() {
 System.out.println("This is a Current Account.");
 }
}

public class a6 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter account type (savings/current): ");
 String type = input.nextLine().toLowerCase();
 BankAccount account;
 if (type.equals("savings")) {
 account = new SavingsAccount();
 } else if (type.equals("current")) {
 account = new CurrentAccount();
 } else {
 System.out.println("Invalid account type.");
 return;
 }
 account.accountType();
 }
}
