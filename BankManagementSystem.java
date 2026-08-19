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
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
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
                    System.out.print("Enter Account ID: ");
                    int depositId = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    boolean depositFound = false;

                    for (Account account : accounts) {
                        if (account.accountId == depositId) {

                            account.balance += depositAmount;
                            depositFound = true;

                            System.out.println("Deposit successful!");
                            System.out.println("Current Balance: " + account.balance);
                            break;
                        }
                    }

                    if (!depositFound) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int withdrawId = sc.nextInt();

                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    boolean withdrawFound = false;

                    for (Account account : accounts) {

                        if (account.accountId == withdrawId) {

                            withdrawFound = true;

                            if (withdrawAmount <= account.balance) {
                                account.balance -= withdrawAmount;

                                System.out.println("Withdraw successful!");
                                System.out.println("Current Balance: " + account.balance);
                            } else {
                                System.out.println("Insufficient balance!");
                            }

                            break;
                        }
                    }

                    if (!withdrawFound) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    int balanceId = sc.nextInt();

                    boolean balanceFound = false;

                    for (Account account : accounts) {

                        if (account.accountId == balanceId) {

                            balanceFound = true;

                            System.out.println("\n----- ACCOUNT DETAILS -----");
                            System.out.println("Account ID: " + account.accountId);
                            System.out.println("Name: " + account.name);
                            System.out.println("Current Balance: " + account.balance);

                            break;
                        }
                    }

                    if (!balanceFound) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Bank Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}