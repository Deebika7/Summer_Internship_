import java.util.Scanner;
public class Login {
    static Scanner sc = new Scanner(System.in);
    public static void loginValidation() {
        System.out.println("Enter Customer Id: ");
        int Customer_Id = sc.nextInt();
        System.out.println("Enter Customer Password: ");
        String customerPassword = sc.next();
        int flag = 0;
        if(Account.bankAccounts.get(Customer_Id).encrptedPassword.equals(Account.encrption(customerPassword))){
            flag=1;
        }
        if (flag == 0) {
            System.out.println("Account doesn't exists");
        }
        else {
            System.out.println("Login Successful: ");
            System.out.println("Customer Id: " + Customer_Id);
            System.out.println("Account Number: " + Account.bankAccounts.get(Customer_Id).accountNumber);
            System.out.println("Account Name: " + Account.bankAccounts.get(Customer_Id).accountName);
            System.out.println("Account Balance: " + Account.bankAccounts.get(Customer_Id).accountBalance);
            System.out.println();
            displayOptions(Customer_Id);
        }
    }

    private static void displayOptions(int customerId) {
        Boolean end=true;
        while (end) {
            System.out.println();
            System.out.println("Enter the number.......");
            System.out.println(" 1. Create a new Gift Card");
            System.out.println(" 2. Top-up the existing Card");
            System.out.println(" 3. Show Gift Card transaction history");
            System.out.println(" 4. Block the existing Card");
            System.out.println(" 5. Logout");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    GiftCard.createGiftcard(customerId);
                    break;
                case 2:
                    GiftCard.topUp(customerId);
                    break;
                case 3:
                    TransactionHistory.display();
                    break;
                case 4:
                    System.out.println("Enter Your Gift_card_number: ");
                    int giftCardNumber = sc.nextInt();
                    Account.bankAccounts.get(customerId).accountBalance+= GiftCard.GiftCards.get(giftCardNumber).GiftCardBalance;
                    if(GiftCard.GiftCards.get(giftCardNumber)!=null) {
                        GiftCard.GiftCards.remove(giftCardNumber);
                        System.out.println(giftCardNumber + " has Blocked Successfully");
                    }
                    else {
                        System.out.println("Gift card doesn't exist!");
                    }
                    break;
                case 5:
                    end=false;
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Number Try Again!!");
            }
        }
    }
}