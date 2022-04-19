package railways;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Scanner;

public class Home {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        Boolean end=true;
        while (end) {
            System.out.println("Enter the number:\n 1.Add Train\n 2.Book ticket\n 3.Passenger Details\n 4. Journey Details\n 5.Exit");
            int n = sc.nextInt();
            switch (n){
            case 1:
                Train.addTrain();
                break;
            case 2:
                System.out.println("Enter to Book Ticket\n 1. By Source and Destination\n 2. By Train ID");
                int choice = sc.nextInt();
                if (choice == 1) {
                    sc.nextLine();
                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();
                    Train.display(source, destination);
                    Booking.Book();
                } else {
                    Booking.Book();
                }
                break;
            case  3:
                System.out.println("Enter PNR Number:");
                int pnr = sc.nextInt();
                sc.nextLine();
                Booking.passengerdetails(pnr);
                break;
            case 4:
                System.out.println("Enter Train id: ");
                int trainid = sc.nextInt();
                sc.nextLine();
                Booking.JourneyDetails(trainid);
                break;
            case 5:
                end=false;
                break;
            default:
                System.out.println("Invalid Choice Try Again!!!!!");
        }
        }
    }
}

