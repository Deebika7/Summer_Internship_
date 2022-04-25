import java.util.*;

public class GiftCard
{
    int GiftCardPin;
    int GiftCardBalance;
    int customerId;
    static HashMap<Integer, GiftCard> GiftCards= new HashMap<>();
    static Scanner sc=new Scanner(System.in);
    public void addGiftCard(int GiftCardPin,int GiftCardBalance,int customerId){
        this.GiftCardPin=GiftCardPin;
        this.GiftCardBalance=GiftCardBalance;
        this.customerId=customerId;
    }
    public static void createGiftcard(int customerId){
        GiftCard Gift_Card_Object=new GiftCard();
        Random rd=new Random();
        int GiftCardNumber = Math.abs(rd.nextInt());
        System.out.println("Enter Set_Gift_card_pin: ");
        int SetGiftCardPin = sc.nextInt();
        System.out.println("Enter Confirm_Gift_card_pin: ");
        int confirmGiftCardPin = sc.nextInt();
        int GiftCardBalance=0;
        if(SetGiftCardPin==confirmGiftCardPin){
            Gift_Card_Object.addGiftCard(SetGiftCardPin,GiftCardBalance,customerId);
            GiftCards.put(GiftCardNumber,Gift_Card_Object);
            System.out.println("Gift Card Created Successfully");
        }
        System.out.println("Your Gift card number is : "+GiftCardNumber);
        System.out.println("Your Current balance is:"+GiftCardBalance);
    }
    public static void topUp(int customerId) {
        System.out.println("Enter the Gift_card_no:");
        int giftCardNumber= sc.nextInt();
        System.out.println("Enter the Top-Up Amount:");
        int topUpAmount=sc.nextInt();
        if(GiftCard.GiftCards.get(giftCardNumber)!=null) {
            if (Account.bankAccounts.get(customerId).accountBalance >= topUpAmount) {
                Account.bankAccounts.get(customerId).accountBalance -= topUpAmount;
                GiftCards.get(giftCardNumber).GiftCardBalance += topUpAmount;
                System.out.println("Top-up Successful");
            }
            else {
                System.out.println("Insufficient Balance in  your bank account");
            }
            TransactionHistory.transaction("top_up", topUpAmount, giftCardNumber);
        }
        else {
            System.out.println("Gift Card doesn't exist");
        }
    }
}