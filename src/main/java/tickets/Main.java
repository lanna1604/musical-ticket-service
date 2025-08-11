package tickets;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Hall hall1 = new Hall(5, 8);
        System.out.println(hall1);

        ArrayList<Ticket> tickets = hall1.generateTickets();
        System.out.println(tickets);

//        MusicalShow show1 = new MusicalShow("Test Show 1", 330);
//        System.out.println(show1);
    }
}