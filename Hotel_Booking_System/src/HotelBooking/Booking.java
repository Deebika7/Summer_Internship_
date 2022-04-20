package HotelBooking;

import java.util.*;

public class Booking {
    String Bookingname;
    int Bookingid;
    String roomtype;
    int No_of_rooms;
    String hotelname;

    public void booked(String hotelname, String Bookingname, int Bookingid, String roomtype, int No_of_rooms) {
        this.hotelname=hotelname;
        this.Bookingname=Bookingname;
        this.Bookingid= Bookingid;
        this.roomtype=roomtype;
        this.No_of_rooms=No_of_rooms;
    }

    static ArrayList<Booking> bookings = new ArrayList<>();
    static Booking b = new Booking();
    static int index = 0;

    static void book() {
        b = new Booking();
        Random rd=new Random();
        int id=Math.abs(rd.nextInt());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Booking name:");
        String bname = sc.nextLine();
        System.out.println("Enter Hotel name: ");
        String hname = sc.nextLine();
        System.out.println("Enter No of Rooms:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Room Type:");
        String rtype = sc.nextLine();
        sc.nextLine();
        if (check1(hname, n, rtype) == 1) {
            System.out.println("Booking successful");
            b.booked(hname,bname,id,rtype,n);
            bookings.add(b);
        } else {
            System.out.println("Your request is not available");
        }

    }
    private static int check1(String hname, int n, String rtype) {

        for (int i = 0; i < Hotel.hotels.size(); i++) {
            if (Hotel.hotels.get(i).Hotelname.equals(hname)) {
                index = i;
            }
        }
        if (check2(rtype) > 0) {
            System.out.println("Rooms are available");
            fill(rtype, n);
            return 1;
        } else {
            return -1;
        }
    }

    private static int check2(String rtype) {
        if (rtype.equals("Ac")) {
            int count1 = 0;
            TreeMap<Integer, Integer> temp = Room.rooms.get(index).Ac.get(index);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == 1) {
                    count1++;
                }
            }
            return count1;
        } else {
            int count2 = 0;
            TreeMap<Integer, Integer> temp = Room.rooms.get(index).Non_Ac.get(index);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == 1) {
                    count2++;
                }
            }
            return count2;
        }
    }

    private static void fill(String rtype, int n) {
        if (rtype.equals("Ac")) {

            TreeMap<Integer, Integer> temp = Room.rooms.get(index).Ac.get(index);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == 1) {
                    entry.setValue(-1);
                    n--;
                }
                if (n == 0) {
                    break;
                }
            }

        } else {

            TreeMap<Integer, Integer> temp = Room.rooms.get(index).Non_Ac.get(index);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == 1) {
                    entry.setValue(-1);
                    n--;
                }
                if (n == 0) {
                    break;
                }
            }

        }
    }
    static void display(int id){
        for (int i=0;i<bookings.size();i++){
            if(bookings.get(i).Bookingid==id){
                System.out.println("Booking name:"+bookings.get(i).Bookingname);
                System.out.println("Hotel name:"+bookings.get(i).hotelname);
                System.out.println("Room type:"+bookings.get(i).roomtype);
                System.out.println("No of rooms:"+bookings.get(i).No_of_rooms);
            }
        }
    }
}