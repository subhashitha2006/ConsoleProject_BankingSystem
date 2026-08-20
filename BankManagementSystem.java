import java.util.HashMap;
import java.util.Scanner;

public class BankManagementSystem {

    static HashMap<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
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

                    if (accounts.containsKey(accountId)) {
                        System.out.println("Account ID already exists!");
                    } else {
                        Account account =
                                new Account(accountId, name, balance);

                        accounts.put(accountId, account);

                        System.out.println("Account created successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int depositId = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    Account depositAccount = accounts.get(depositId);

                    if (depositAccount != null) {
                        depositAccount.balance += depositAmount;

                        System.out.println("Deposit successful!");
                        System.out.println(
                                "Current Balance: "
                                + depositAccount.balance);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int withdrawId = sc.nextInt();

                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    Account withdrawAccount = accounts.get(withdrawId);

                    if (withdrawAccount != null) {

                        if (withdrawAmount <= withdrawAccount.balance) {

                            withdrawAccount.balance -= withdrawAmount;

                            System.out.println("Withdraw successful!");
                            System.out.println(
                                    "Current Balance: "
                                    + withdrawAccount.balance);

                        } else {
                            System.out.println("Insufficient balance!");
                        }

                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}