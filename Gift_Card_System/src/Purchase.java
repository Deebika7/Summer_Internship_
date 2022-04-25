import java.util.Scanner;

public class Purchase {
    static Scanner sc=new Scanner(System.in);
    public static void purchase() {
        System.out.println("Enter bill amount: ");
        int billAmount=sc.nextInt();
        System.out.println("Enter Gift Card Number: ");
        int giftCardNumber=sc.nextInt();
        System.out.println("Enter PIN: ");
        int pin=sc.nextInt();
        if(pin== GiftCard.GiftCards.get(giftCardNumber).GiftCardPin){
            if(GiftCard.GiftCards.get(giftCardNumber).GiftCardBalance>=billAmount) {
                GiftCard.GiftCards.get(giftCardNumber).GiftCardBalance -= billAmount;
                TransactionHistory.transaction("purchase",billAmount, giftCardNumber);
                System.out.println("Available Balance : "+ GiftCard.GiftCards.get(giftCardNumber).GiftCardBalance);
                Reward.reward(giftCardNumber,billAmount);
                billAmount=0;
                Reward.reward(giftCardNumber,billAmount);
                        System.out.println("Current Reward Points: "+Reward.reward.get(giftCardNumber));
                System.out.println("Available Balance After Reward : "+ GiftCard.GiftCards.get(giftCardNumber).GiftCardBalance);
            }
            else {
                System.out.println("InSufficient Balance");
            }
        }
        else {
            System.out.println("Gift card doesn't exist!");
        }

    }
}