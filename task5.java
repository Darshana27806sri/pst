import java.util.Scanner;
public class Main {
static class BankAccount {
private double balance = 0.0;
public void deposit(double amount) {
balance += amount;
}
public void withdraw(double amount) {
balance -= amount;
}
public double getBalance() {
return balance;
}
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
if (!sc.hasNextInt()) return;
int n = sc.nextInt();
BankAccount account = new BankAccount();
for (int i = 0; i < n; i++) {
String op = sc.next();
double amt = sc.nextDouble();
if (op.equalsIgnoreCase("Deposit")) {
account.deposit(amt);
} else if (op.equalsIgnoreCase("Withdraw")) {
account.withdraw(amt);
}
}
System.out.println((long) account.getBalance());
}
}