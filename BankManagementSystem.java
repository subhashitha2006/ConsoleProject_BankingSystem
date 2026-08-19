import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {

    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Create Account
                    System.out.print("Enter Account ID: ");
                    int accountId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    boolean exists = false;

                    for (Account account : accounts) {
                        if (account.accountId == accountId) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Account ID already exists!");
                    } else {
                        Account account = new Account(accountId, name, balance);
                        accounts.add(account);

                        System.out.println("Account created successfully!");
                    }
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter Account ID: ");
                    int depositId = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    boolean found = false;

                    for (Account account : accounts) {
                        if (account.accountId == depositId) {

                            account.balance += depositAmount;
                            found = true;

                            System.out.println("Deposit successful!");
                            System.out.println("Current Balance: " + account.balance);
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}