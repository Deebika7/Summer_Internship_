import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class TransactionHistory {
    static HashMap<Integer,ArrayList> transaction=new HashMap<>();
    static Scanner sc=new Scanner(System.in);
    public static void transaction(String typeOfTransaction,int amount,int giftCardNumber){
        LocalDateTime Datetime_object=LocalDateTime.now();
        DateTimeFormatter date= DateTimeFormatter.ofPattern("dd-MM-yyy");
        DateTimeFormatter time= DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate=Datetime_object.format(date);
        String formattedTime=Datetime_object.format(time);
        String str="";
        if(typeOfTransaction=="top_up"){
            str+="Rs. "+amount+" "+"has been credited to your card at "+formattedTime+" on "+formattedDate;
        }
        else {
            str+="Rs. "+amount+" "+"has been debited from your card at "+formattedTime+" on "+formattedDate;
        }
        if(transaction.get(giftCardNumber)==null){
            ArrayList<String> list=new ArrayList<>();
            list.add(str);
            transaction.put(giftCardNumber,list);
        }
        else {
            ArrayList<String> list=transaction.get(giftCardNumber);
            list.add(str);
        }
    }
    public static void display() {
        System.out.println("Enter Your Gift_card_number: ");
        int giftCardNumber=sc.nextInt();
        if(transaction.get(giftCardNumber)!=null) {
            ArrayList<String> list = transaction.get(giftCardNumber);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        else {
            System.out.println("Gift Card Doesn't exist");
        }
    }
}