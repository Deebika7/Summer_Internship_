package HotelBooking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Hotel {
    String Hotelname;
    String Hotellocation;
    int noofrooms;
    public void Hotel(String Hotelname,String Hotellocation,int noofrooms){
        this.Hotelname=Hotelname;
        this.Hotellocation=Hotellocation;
        this.noofrooms=noofrooms;
    }

    static Hotel h=new Hotel();
    static ArrayList<Hotel> hotels=new ArrayList<>();
    public static void addhotel(){
        h=new Hotel();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Hotel name:");
        String hname=sc.nextLine();
        System.out.println("Enter Hotel Location:");
        String hlocation=sc.nextLine();
        System.out.println("Enter No of Rooms:");
        int nor=sc.nextInt();
        h.Hotel(hname,hlocation,nor);
        hotels.add(h);
        Room.addroom(nor);
        view();
    }
    static void view(){
        for (int i=0;i<hotels.size();i++){
            System.out.println();
            System.out.println("Hotel Name:"+hotels.get(i).Hotelname);
            System.out.println("Hotel Location:"+hotels.get(i).Hotellocation);
            System.out.println("Number of Rooms:"+hotels.get(i).noofrooms);
        }
        System.out.println("Ac Room number and no of beds");
        for (int i=0;i<Room.Ac.size();i++) {
            System.out.println(Room.rooms.get(i).Ac.get(i));
            System.out.println(Room.rooms.get(i).Ac_Roomid.get(i));
        }
        System.out.println("Non_Ac Room number and no of beds");
        for (int i=0;i<Room.Ac.size();i++) {
            System.out.println(Room.rooms.get(i).Non_Ac.get(i));
            System.out.println(Room.rooms.get(i).Non_Ac_Roomid.get(i));
            System.out.println();
        }
    }
}
