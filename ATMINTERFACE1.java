import java.util.Scanner;

public class ATMINTERFACE1 {
    private double balance;
    private int userPIN;

    public ATMINTERFACE1(double initialBalance, int initialPIN) {
        this.balance = initialBalance;
        this.userPIN = initialPIN;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("money " + amount + " is deposite succesfully and your current balance is: "  + balance);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("money " + amount + " withdral succesfully and your current balance is: " + balance);
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public boolean validatePIN(int pin) {
        return pin == userPIN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup initial PIN and balance
        System.out.print("Set your ATM PIN: ");
        int initialPIN = scanner.nextInt();

        System.out.print("Set your initial balance: ");
        double initialBalance = scanner.nextDouble();

        ATMINTERFACE1 atm = new ATMINTERFACE1(initialBalance, initialPIN);

        // Ask for PIN to access ATM functionalities
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (atm.validatePIN(pin)) {
            int option;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 4);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
        scanner.close();
    }
}
