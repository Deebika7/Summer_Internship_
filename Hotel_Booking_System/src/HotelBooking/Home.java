package HotelBooking;

import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Boolean end = true;
        Scanner sc = new Scanner(System.in);
        while (end) {
            System.out.println("Enter the number\n 1. Admin\n 2. User\n 3. Exit");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter admin name:");
                    String adminname = sc.next();
                    System.out.println("Enter admin password:");
                    String adminpassword = sc.next();
                    if (adminpassword.equals("admin123") && adminname.equals("admin")) {
                        Admin.admin();
                    }
                    else {
                        System.out.println("Invalid Login");
                    }
                    break;
                case 2:
                    System.out.println("Enter user name:");
                    String username = sc.next();
                    System.out.println("Enter user password:");
                    String userpassword = sc.next();
                    if (userpassword.equals("user123") && username.equals("user")) {
                        User.user();
                    }
                    else {
                        System.out.println("Invalid Login");
                    }
                    break;
                case 3:
                    end = false;
                    break;
                default:
                    System.out.println("Invalid Selection Try again!!");
            }
        }
    }
}
