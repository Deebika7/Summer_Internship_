package railways;

import java.util.*;

public class Train {
    int trainid;
    String trainame;
    String fromstation;
    String tostation;
    List<List<String>> map = new ArrayList<>();
    int no_of_station;
    List<TreeMap<String, Integer>> coachtype = new ArrayList<>();
    public static ArrayList<Train> trains=new ArrayList<>();

    public static void display(String source, String destination) {
        int f=1,index=0;
        for(int i=0;i<trains.size();i++){
                for (int j=0;j<trains.get(i).map.size();j++){
                    if(trains.get(i).map.get(i).get(j).equals(source)){
                        f=0;
                        index=j;
                    }
                }
            }
        if(f==0) {
            for (int i = 0; i < trains.size(); i++) {
                for (int j = 0; j < trains.get(i).map.size(); j++) {
                    if (trains.get(i).map.get(i).get(j).equals(destination)&&index<=j) {
                        System.out.println("train number: " + trains.get(i).trainid + "\ntrain name: " + trains.get(i).trainame + "\ntrain from station: " + trains.get(i).fromstation + "\ntrain to station: " + trains.get(i).tostation);
                    }
                }
            }
        }
        else {
            System.out.println("Trains are Unavailable");
        }
    }

    public void Train(int trainid, String trainame, String fromstation, String tostation, int no_of_station) {
        this.trainid = trainid;
        this.trainame = trainame;
        this.fromstation = fromstation;
        this.tostation = tostation;
        this.no_of_station = no_of_station;
    }
    public void stops(ArrayList<String> map) {
        this.map.add(new ArrayList<>(map));
    }
    public void addCoach(TreeMap coachtypes) {
        this.coachtype.add(new TreeMap<>(coachtypes));
    }
    static Scanner sc = new Scanner(System.in);
    static Train t1 = new Train();
    public static void addTrain() {
        t1 = new Train();
        System.out.print("Enter train name: ");
        String tname = sc.nextLine().trim();
        sc.nextLine();
        System.out.print("Enter train number: ");
        int tnum = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter From station: ");
        String source = sc.nextLine().trim();
        sc.nextLine();
        System.out.print("Enter To station: ");
        String destination = sc.nextLine().trim();
        sc.nextLine();
        System.out.println("Enter no of stations between source and destination: ");
        int n = sc.nextInt();
        sc.nextLine();
        t1.Train(tnum, tname, source, destination, n);
        System.out.println("Enter between Stations name: ");
        ArrayList<String> map=new ArrayList<>();
        map.add(source);
        for (int i = 1; i <=n; i++) {
            String betweenstation = sc.next();
            map.add(betweenstation);
        }
        map.add(destination);
        t1.stops(map);
        char ch = 'y';
        int count=0;
        TreeMap<String,Integer> coachtypes=new TreeMap<>();
        while (ch == 'y' || ch == 'Y') {
            if(count>16){
                System.out.println("Coach limit exceeded!!");
                break;
            }
            System.out.print("Enter coach type: ");
            String coach_type = sc.next();
            sc.nextLine();
            System.out.print("Number of seats: ");
            int seat_count = sc.nextInt();
            if (seat_count<6||seat_count>10){
                System.out.println("Invalid Seat Count");
            }
            coachtypes.put(coach_type,seat_count);
            System.out.println("If you want to add more coaches (y/n): ");
            ch = sc.next().charAt(0);
            count++;
        }
        t1.addCoach(coachtypes);
        trains.add(t1);
        Train.view();
        System.out.println("Train Added Successfully");
    }
    static void  view() {
        System.out.println("Trains");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println("train number: " + trains.get(i).trainid + "\ntrain name: " + trains.get(i).trainame + "\ntrain from station: " + trains.get(i).fromstation + "\ntrain To Place: " + trains.get(i).tostation);
            System.out.println("between stations:\n"+trains.get(i).map.get(i));
            System.out.println(trains.get(i).coachtype.get(i));
        }
    }
}
