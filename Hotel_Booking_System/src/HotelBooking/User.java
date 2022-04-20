package HotelBooking;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class User {

    public static void user() {
        Scanner sc=new Scanner(System.in);
            Boolean end=true;
            while (end){
                System.out.println("Enter the Selection Number");
                System.out.println(" 1. Book Room");
                System.out.println(" 2. Booking History");
                System.out.println(" 3. Room Availability");
                System.out.println(" 4. Go Back to Home");
                int n= sc.nextInt();
                switch (n){
                    case 1:
                        System.out.println("  How Could we help you: ");
                        System.out.println("   Enter your choice to book rooms:");
                        System.out.println("     1.Based on Room Type");
                        System.out.println("     2.Based on Location");
                        System.out.println("     3.Based on Budget");
                        int choice= sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter the type of room you would like:");
                                sc.nextLine();
                                String type= sc.nextLine();
                                Room.Type(type);
                                Booking.book();
                                break;
                            case 2:
                                System.out.println("Enter your Location");
                                sc.nextLine();
                                String location= sc.nextLine();
                                Room.location(location);
                                Booking.book();
                                break;
                            case 3:
                                System.out.println("Enter your Budget");
                                sc.nextLine();
                                int budget= sc.nextInt();
                                Room.Budget(budget);
                                Booking.book();
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                        break;
                    case 2:
                        System.out.println("  Enter Your Booking id:");
                        int id=sc.nextInt();
                        sc.nextLine();
                        Booking.display(id);
                        break;
                    case 3:
                        System.out.println("  Enter the Hotel name:");
                        String s=sc.nextLine();
                        sc.nextLine();
                        Room.availability(s);
                        break;
                    case 4:
                        end=false;
                        break;
                    default:
                        System.out.println("Invalid Selection....Try again!!");
                }
                //System.out.println("Would you like to go back to Home(y/n):");
            }
        }
    }

