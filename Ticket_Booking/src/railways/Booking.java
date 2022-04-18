package railways;

import java.util.*;

public class Booking {
    int pnr;
    String source;
    String destination;
    int traino;
    String coach;
    int no_of_passengers;
    List<List<String>> name=new ArrayList<>();
    List<List<Integer>> age=new ArrayList<>();
    List<List<String>> gender=new ArrayList<>();

    public void generateTicket(int pnr,String source,String destination,int traino,String coach,int no_of_passengers){
        this.pnr=pnr;
        this.source=source;
        this.destination=destination;
        this.traino=traino;
        this.coach=coach;
        this.no_of_passengers=no_of_passengers;
    }
    public void addTicket(ArrayList name, ArrayList age, ArrayList gender){
        this.name.add(new ArrayList<>(name));
        this.age.add(new ArrayList<>(age));
        this.gender.add(new ArrayList<>(gender));
    }
    static Scanner sc=new Scanner(System.in);
    static Booking b1=new Booking();
    static int index=0;
    static ArrayList<Booking> tickets=new ArrayList<>();
    static Boolean booking(String type, int noofseats){
            if(seatcheck(type,noofseats)==1){
                System.out.println("Seats are available");
                System.out.println("Booking Successful");
                return true;
            }
            else {
                System.out.println("Seats are unavailable!!");
                return false;
            }
    }

    private static void displaybooking(int pnr) {
        int index = 0;
        for (int i = 0; i <tickets.size(); i++) {
            if (tickets.get(i).pnr == pnr) {
                index = i;
                break;
            }
        }
        System.out.println();
        System.out.println("From Station:" + tickets.get(index).source + "\nTo Station:" + tickets.get(index).destination + "\nPNR:" + tickets.get(index).pnr);
    }

    static void Book(){
        b1=new Booking();
        System.out.println("Enter train no:");
        int tno=sc.nextInt();
        if(check(tno)==1) {
            sc.nextLine();
            Random rd=new Random();
            int pnr= Math.abs(rd.nextInt());
            System.out.println("Enter source place:");
            String source = sc.nextLine();
            System.out.println("Enter destination place:");
            String destination = sc.nextLine();
            System.out.println("Enter coach type: ");
            String type = sc.nextLine();
            System.out.println("Enter No of Passengers:");
            int seats = sc.nextInt();
            sc.nextLine();
            if(seats<=16) {
                b1.generateTicket(pnr, source, destination, tno, type, seats);
                ArrayList<String> pname = new ArrayList<>();
                ArrayList<Integer> page = new ArrayList<>();
                ArrayList<String> pgender = new ArrayList<>();
                for (int i = 0; i < seats; i++) {
                    System.out.println(i+1+" ");
                    System.out.println("Enter the passenger name: ");
                    pname.add(sc.nextLine());
                    sc.nextLine();
                    System.out.println("Enter the passenger age: ");
                    page.add(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter the passenger Gender: ");
                    pgender.add(sc.next());
                }
                b1.addTicket(pname, page, pgender);
                if (booking(type, seats)) {
                    tickets.add(b1);
                    displaybooking(pnr);
                }
            }
            else {
                System.out.println("Seats are Unavailable!!");
            }
        }
        else{
            System.out.println("Train doesn't exist");
        }
    }
    private static int seatcheck(String type, int noofseats) {

        if(Train.trains.get(index).coachtype.get(index).containsKey(type)){
            int value=Train.trains.get(index).coachtype.get(index).get(type);
            String str="";
            Map<String, Integer> temp =Train.trains.get(index).coachtype.get(index);
            for (Map.Entry<String,Integer> entry:temp.entrySet()){
                if(entry.getValue()==value){
                    str+=entry.getKey();
                }
            }
             if(value>=noofseats){
                 Train.trains.get(index).coachtype.get(index).replace(str,value-noofseats);
                 return 1;
             }
        }
        return -1;
    }
    private static int check(int tno) {
        for(int i=0;i<Train.trains.size();i++){
            if(Train.trains.get(i).trainid==tno){
                index=i;
                return 1;
            }
        }
        return -1;
    }
    public static void JourneyDetails(int trainid) {
        for (int i=0;i<tickets.size();i++){
            if(tickets.get(i).traino==trainid){
                System.out.println();
                System.out.println("PNR Number: "+tickets.get(i).pnr);
                System.out.println("Source: "+tickets.get(i).source);
                System.out.println("Destination: "+tickets.get(i).destination);
                System.out.println("No of Passengers: "+tickets.get(i).no_of_passengers);
                for (int j=0;j<tickets.get(i).name.get(i).size();j++){
                    System.out.println(j+1+".Name: "+tickets.get(i).name.get(i).get(j)+" ");
                    System.out.print(j+1+".Age: "+tickets.get(i).age.get(i).get(j)+" ");
                    System.out.print(j+1+".Gender: "+tickets.get(i).gender.get(i).get(j));
                }
                System.out.println();
            }
        }
    }
    public static void passengerdetails(int pnr) {
        for (int i=0;i<tickets.size();i++){
            if (tickets.get(i).pnr==pnr){
                System.out.println("Train No: "+tickets.get(i).traino);
                System.out.println("Source: "+tickets.get(i).source);
                System.out.println("Destination: "+tickets.get(i).destination);
                System.out.println("No of Passengers: "+tickets.get(i).no_of_passengers);
                for (int j=0;j<tickets.get(i).name.get(i).size();j++){
                    System.out.println(j+1+".Name: "+tickets.get(i).name.get(i).get(j)+" ");
                    System.out.print("Age: "+tickets.get(i).age.get(i).get(j)+" ");
                    System.out.print("Gender: "+tickets.get(i).gender.get(i).get(j));
                    System.out.println();
                }
            }
        }
    }
}