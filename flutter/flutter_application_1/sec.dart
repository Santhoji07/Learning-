
void main() {

  print("Personal Budget Manager");

  double income = 100000;

  double expense = 79999;

  double tax = income * 0.10;

  double budget = income - expense - tax;

  print("\n financial summary for the month:");

  print("Income: $income");
  print("Expenses: $expense");
  print("Tax (10%): $tax");
  print("Remaining Budget: $budget");
 
  if (budget<income) {
    print("You are eligible for a personal loan as your budget is lower than your income.");
  }

  if (income > expense) {
    print("You can consider investing in stocks since your income is higher than your expenses.");
  }

  print("\nThank you");
}