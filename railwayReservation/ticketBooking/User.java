package ticketBooking;

import java.util.*;

public class User extends Home {

    static int booking(int num) {
            if(num<=check1()){
                fill(1,num);
                return 1;
            }
            else if(num<=check2()){
                fill(2,num);
                return 3;
            }
            else if(num<=2){
                if(waiting()<=2) {
                    return -1;
                }
            }
                return -2;
    }

    public static int check1() {
        int count1 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (coach1[i][j] == false) {
                    count1++;
                }
            }
        }
        return count1;
    }
    public static int waiting(){
        int count3=0;
        for(int i=0;i<2;i++){
            if(waitingTicket.isEmpty()){
                count3++;
            }
        }
        return count3;
    }


    public static int check2() {
        int count2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (coach2[i][j] == false) {
                    count2++;
                }
            }
        }
        return count2;
    }
    static void fill(int y,int n){
        if(y==1){
            for (int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    if(coach1[i][j]==false) {
                        coach1[i][j] = true;
                        n--;
                    }
                    if(n==0){
                        break;
                    }
                }
                if(n==0){
                    break;
                }
            }
        }
        else {
            for (int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    if(coach2[i][j]==false) {
                        coach2[i][j] = true;
                        n--;
                    }
                    if(n==0){
                        break;
                    }
                }
                if(n==0){
                    break;
                }
            }
        }
        }


    public static void generateTicket() {
        Booked = new bookTicket();
        Random rd = new Random();
        System.out.print("Enter From station: ");
        String source = sc.next();
        System.out.print("Enter To station: ");
        String destination = sc.next();
        System.out.print("Enter No .Of Passengers: ");
        int n = sc.nextInt();
        System.out.println("Enter Passengers Name:");
        for (int i = 1; i <=n; i++) {
            System.out.println("Enter Passenger "+i+" name:");
            Booked.passengersname.add(sc.next());
        }
        int pnr =Math.abs( rd.nextInt());
        int book=booking(n);
        if(book==1){
            int c=1;
            System.out.println("Seats are available Booking Confirmed in coach 1");
            Booked.confirmed(source,destination,n,pnr,c);
            confirmedTicket.add(Booked);
            display(pnr);
        }
        else if(book==3){
            int c=2;
            System.out.println("Seats are available Booking Confirmed in coach 2");
            Booked.confirmed(source,destination,n,pnr,c);
            confirmedTicket.add(Booked);
            display(pnr);
        }
        else if(book==-1){
            System.out.println("Seats are in waiting list!");
            Booked.waitticket(source,destination,n,pnr);
            waitingTicket.add(Booked);
            display(pnr);
        }
        else if(book==-2){
            System.out.println("Seats are not available");
        }

    }

    static void display(int p) {
        int index = 0;
        for (int i = 0; i < confirmedTicket.size(); i++) {
            if (confirmedTicket.get(i).pnr == p) {
                index = i;
            }
        }
        System.out.println();
        System.out.println("From Station:" + confirmedTicket.get(index).fromstation + "\nTo Station:" + confirmedTicket.get(index).tostation + "\nPNR:" + confirmedTicket.get(index).pnr);
    }
}
