package ticketBooking;

public class cancelTIcket extends Home {
    static int index = 0;

    public void cancelTicket() {
        System.out.println("Enter the PNR number to cancel Tickets:");
        int pnr = sc.nextInt();
        int flag = 0;
        for (int i = 0; i < confirmedTicket.size(); i++) {
            if (confirmedTicket.get(i).pnr == pnr) {
                flag = 1;
                index = i;
            }
        }
        if (flag == 1) {
            cancelling(confirmedTicket.get(index).noofpassengers, confirmedTicket.get(index).coach);
        } else {
            System.out.println("Invalid PNR Number");
        }
    }

    private void cancelling(int cancelno, int c) {
        unfill(cancelno, c);
        if (user.waiting() == 2) {
            System.out.println("cancelled successfully!!");
            confirmedTicket.remove(index);
        } else {
            String from = confirmedTicket.get(index).fromstation;
            String to = confirmedTicket.get(index).tostation;
            waitingactivation(from, to,c);
            System.out.println("cancelled successfully!!");
            confirmedTicket.remove(index);
        }
    }

    private void waitingactivation(String cancelfrom, String cancelto,int c) {
        int count = 0;
        for (int i = 0; i < waitingTicket.size(); i++) {
            String fromwait = waitingTicket.get(i).fromstation;
            String towait = waitingTicket.get(i).tostation;
            if (map.get(cancelfrom) <= map.get(fromwait) && map.get(cancelto) >= map.get(towait)) {
                confirmedTicket.add(waitingTicket.get(i));
                waitingTicket.remove(i);
                count++;
            }
        }
        user.fill(c,count);
    }

    private void unfill(int cancelno, int coach) {
        if (coach == 1) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (coach1[i][j] == true) {
                        coach1[i][j] = false;
                        cancelno--;
                    }
                    if (cancelno == 0) {
                        break;
                    }
                }
                if (cancelno == 0) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (coach2[i][j] == true) {
                        coach2[i][j] = false;
                        cancelno--;
                    }
                    if (cancelno == 0) {
                        break;
                    }
                }
                if (cancelno == 0) {
                    break;
                }
            }
        }
    }

}
