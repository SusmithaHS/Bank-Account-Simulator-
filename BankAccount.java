
package elevatelabs;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for " + accountHolder);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs " + amount);
            System.out.println("Rs " + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs " + amount);
            System.out.println("Rs " + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String entry : transactionHistory) {
            System.out.println("- " + entry);
        }
    }
}

public class BankAccount{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        Account account = new Account(name);

        int choice;
        do {
            System.out.println("\n Bank Menu ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: Rs ");
                    double depositAmt = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: Rs ");
                    double withdrawAmt = Double.parseDouble(scanner.nextLine());
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you ");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 5);
    }
}
