import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {

    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        boolean exists = false;

        // Check duplicate Account ID
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

        sc.close();
    }
}