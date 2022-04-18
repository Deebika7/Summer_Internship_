package ticketBooking;

import java.util.*;

public class Home {

    static User user = new User();
    static Scanner sc = new Scanner(System.in);
    static cancelTIcket cancel = new cancelTIcket();
    static bookTicket Booked = new bookTicket();
    static boolean[][] coach1 = new boolean[6][6];
    static boolean[][] coach2 = new boolean[6][6];
    static ArrayList<bookTicket> confirmedTicket = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<bookTicket> waitingTicket = new ArrayList<>();


    public static void main(String[] args) {
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~WELCOME!!!~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        Boolean end = true;
        while (end) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println(" 1. Book Ticket\n 2. Cancel Ticket\n 3. Print Occupancy\n 4. Display Waiting List\n 5. Display Confirmed Tickets\n 6. Exit ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    user.generateTicket();
                    break;
                case 2:
                    cancel.cancelTicket();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    waitview();
                    break;
                case 5:
                    confirmedview();
                    break;
                case 6:
                    end = false;
                    break;
                default:
                    System.out.println("Invalid Selection Try again");
            }
        }

    }

    private static void confirmedview() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONFIRMED LIST!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < confirmedTicket.size(); i++) {
            System.out.println();
            System.out.println("PNR Number: "+confirmedTicket.get(i).pnr);
            System.out.println("From Station: "+confirmedTicket.get(i).fromstation);
            System.out.println("To Station: "+confirmedTicket.get(i).tostation);
            System.out.println();
        }
        if(confirmedTicket.size()==0){
            System.out.println("No seats have been booked!!");
        }
    }

    private static void view() {
        System.out.println("Coach 1:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (coach1[i][j] == true) {
                    System.out.print(" * ");
                } else {
                    System.out.print((" - "));
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Coach 2:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (coach2[i][j] == true) {
                    System.out.print(" * ");
                } else {
                    System.out.print((" - "));
                }
            }
            System.out.println();
        }
    }

    static void waitview() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WAITING LIST!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < waitingTicket.size(); i++) {
            System.out.println();
            System.out.println("PNR Number: "+waitingTicket.get(i).pnr);
            System.out.println("From Station: "+waitingTicket.get(i).fromstation);
            System.out.println("To Station: "+waitingTicket.get(i).tostation);
            System.out.println();
        }
        if(waitingTicket.size()==0){
            System.out.println("No seats are under waiting!!");
        }
    }
}
