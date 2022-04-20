package HotelBooking;
import java.util.*;

public class Room {
    static List<TreeMap<Integer,Integer>> Ac=new ArrayList<>();
    static List<TreeMap<Integer,Integer>> Non_Ac=new ArrayList<>();
    static List<TreeMap<Integer,Integer>> Non_Ac_Roomid=new ArrayList<>();
    static List<TreeMap<Integer,Integer>> Ac_Roomid=new ArrayList<>();
    static Room r=new Room();
    static ArrayList<Room> rooms=new ArrayList<>();

    public static void location(String location) {
        for (int i=0;i<Hotel.hotels.size();i++){
            if(Hotel.hotels.get(i).Hotellocation.equals(location)){
                System.out.println("Hotel Name: "+Hotel.hotels.get(i).Hotelname);
            }
        }
    }

    public static void Budget(int budget) {
        int in=1;
        System.out.println("Hotels List: ");
        if(budget>=1000&&budget<=500){
            for (int i=0;i<Room.rooms.size();i++){
                if(!Room.rooms.get(i).Non_Ac.get(i).isEmpty()){
                    System.out.println((in++)+"."+Hotel.hotels.get(i).Hotelname);
                }
            }
        }
        else if(budget>=1000){
            for (int i=0;i<Room.rooms.size();i++){
                if(!Room.rooms.get(i).Ac.get(i).isEmpty()){
                    System.out.println((in++)+"."+Hotel.hotels.get(i).Hotelname);
                }
            }
        }
    }

    public static void Type(String type) {
        int in=1;
        System.out.println("Hotels List: ");
        if(type.equals("Non Ac")){
            for (int i=0;i<Room.rooms.size();i++){
                if(!Room.rooms.get(i).Non_Ac.get(i).isEmpty()){
                    System.out.println((in++)+"."+Hotel.hotels.get(i).Hotelname);
                }
            }
        }
        else if(type.equals("Ac")){
            for (int i=0;i<Room.rooms.size();i++){
                if(!Room.rooms.get(i).Ac.get(i).isEmpty()){
                    System.out.println((in++)+"."+Hotel.hotels.get(i).Hotelname);
                }
            }
        }

    }


    public void addAc(TreeMap<Integer,Integer> Ac) {
        this.Ac.add(new TreeMap<>(Ac));
    }
    public void addNon_Ac(TreeMap<Integer,Integer> Non_Ac) {
        this.Non_Ac.add(new TreeMap<>(Non_Ac));
    }
    public void addAc_Roomid(TreeMap<Integer,Integer> Ac_Roomid) {
        this.Ac_Roomid.add(new TreeMap<>(Ac_Roomid));
    }
    public void addNon_Ac_Roomid(TreeMap<Integer,Integer> Non_Ac_Roomid) {
        this.Non_Ac_Roomid.add(new TreeMap<>(Non_Ac_Roomid));
    }

    public static void addroom(int nor) {
        r=new Room();
        Scanner sc=new Scanner(System.in);
        TreeMap<Integer,Integer> Ac=new TreeMap<>();
        TreeMap<Integer,Integer> Non_Ac=new TreeMap<>();
        TreeMap<Integer,Integer> Non_Ac_Roomid=new TreeMap<>();
        TreeMap<Integer,Integer> Ac_Roomid=new TreeMap<>();
        for (int i=0;i<nor;i++) {
            System.out.println("Enter Room Type (Ac/Non Ac):");
            String rtype = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter Room Id:");
            int rid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter No of Beds:");
            int noofbeds = sc.nextInt();
            sc.nextLine();
            if (rtype.equals("Ac")) {
                Ac.put(rid, 1);
                Ac_Roomid.put(rid, noofbeds);
            } else {
                Non_Ac.put(rid, 1);
                Non_Ac_Roomid.put(rid, noofbeds);
            }
        }
            r.addAc(Ac);
            r.addAc_Roomid(Ac_Roomid);
            r.addNon_Ac(Non_Ac);
            r.addNon_Ac_Roomid(Non_Ac_Roomid);
            rooms.add(r);
            System.out.println("Room Added successfully!");
        }
        static void availability(String hname){
            int in=0;
            for (int i=0;i<Hotel.hotels.size();i++){
                if(Hotel.hotels.get(i).Hotelname.equals(hname)){
                    in=i;
                }
            }
            System.out.println("Hotel Name: "+Hotel.hotels.get(in).Hotelname);
            System.out.println("Hotel Location: "+Hotel.hotels.get(in).Hotellocation);
            int count2=0;
            TreeMap<Integer, Integer> temp = Room.rooms.get(in).Non_Ac.get(in);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == 1) {
                    count2++;
                }
            }
            System.out.println("Number Of Non-Ac Rooms Available: "+count2);
            int count1 = 0;
            TreeMap<Integer, Integer> temp1 = Room.rooms.get(in).Ac.get(in);
            for (Map.Entry<Integer, Integer> entry : temp1.entrySet()) {
                if (entry.getValue() == 1) {
                    count1++;
                }
            }
            System.out.println("Number Of Ac Rooms Available: "+count1);
        }
    }