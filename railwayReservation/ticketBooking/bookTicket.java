package ticketBooking;

import java.util.ArrayList;

public class bookTicket {
    String fromstation;
    String tostation;
    int noofpassengers;
    int pnr;
    int coach;
    ArrayList<String> passengersname=new ArrayList<>();
    public void confirmed(String fromstation,String tostation,int noofpassengers,int pnr,int coach){
        this.fromstation=fromstation;
        this.tostation=tostation;
        this.noofpassengers=noofpassengers;
        this.pnr=pnr;
        this.coach=coach;
    }
    public void waitticket(String fromstation,String tostation,int noofpassengers,int pnr){
        this.fromstation=fromstation;
        this.tostation=tostation;
        this.noofpassengers=noofpassengers;
        this.pnr=pnr;
    }
}
