package HotelBooking;

import java.util.Scanner;

public class Admin {

    static void admin(){
        char ch='y';
        Scanner sc=new Scanner(System.in);
        while (ch=='y'||ch=='Y'){
            Hotel.addhotel();
             System.out.println("Would you like to add more hotel(y/n):");
             ch=sc.next().charAt(0);
        }
    }
}
