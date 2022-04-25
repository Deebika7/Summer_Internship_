import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Account {
    int accountNumber;
    String accountName;
    int accountBalance;
    String encrptedPassword;
    public void bankAccount(int accountNumber, String accountName, int accountBalance, String encrptedPassword) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.encrptedPassword = encrptedPassword;
    }
    static HashMap<Integer,Account> bankAccounts=new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static void createAccount() {
        Account account_Object = new Account();
        System.out.println("Enter Customer Id: ");
        int customerId = sc.nextInt();
        System.out.println("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Account Name: ");
        String accountName = sc.next();
        System.out.println("Enter Account Balance: ");
        int accountBalance = sc.nextInt();
        System.out.println("Enter Account Password: ");
        String accountPassword = sc.next();
        String encrptedPassword = encrption(accountPassword);
        account_Object.bankAccount(accountNumber, accountName, accountBalance, encrptedPassword);
        bankAccounts.put(customerId,account_Object);
    }
    static String encrption(String accountPassword) {
        String encryptedPassword = "";
        for (int i = 0; i < accountPassword.length(); i++) {
            char character;
            if (accountPassword.charAt(i) == 'z') {
                character = 'a';
            } else if (accountPassword.charAt(i) == '9') {
                character = '1';
            } else if (accountPassword.charAt(i) == 'Z') {
                character = 'A';
            } else {
                character = (char) (accountPassword.charAt(i) + 1);
            }
            encryptedPassword += character;
        }
        return encryptedPassword;
    }

    public static void main(String[] args) {
        System.out.println("Welcome!!");
        while (true) {
            System.out.println();
            System.out.println("Enter the number");
            System.out.println("1. To Add Account");
            System.out.println("2. Account Login");
            System.out.println("3. Purchase");
            System.out.println("4. Logout");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    Login.loginValidation();
                    break;
                case 3:
                    Purchase.purchase();
                    break;
                case 4:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice Try again!");
            }
        }
    }
}