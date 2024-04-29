//TASK 03 - ATM INTERFACE
//CODESOFT

import java.util.Scanner;

public class SimpleATM {
    private double balance;
    private Scanner scanner;

    public SimpleATM(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public void runATM() {
        boolean active = true;
        while (active) {
            System.out.println("\nATM Interface");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit Money");
            System.out.println("3 - Withdraw Money");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    active = false;
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        SimpleATM atm = new SimpleATM(1000.00); // Starting balance of $1000.00
        atm.runATM();
    }
}

