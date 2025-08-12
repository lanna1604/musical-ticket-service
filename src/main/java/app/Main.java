package app;


import tickets.*;

public class Main {
    public static void main(String[] args) {
        Hall hall1 = new Hall(2, 3);
//        System.out.println(hall1);

        MusicalShow show1 = new MusicalShow("Test Show 1");
        show1.createPerformance(hall1, "17.08.2025 12:35", 249.99);
        show1.createPerformance(hall1, "15.08.2025 08:00", 200);

        Visitor visitor6 = new Visitor("   \tJames Gosling     \n", "1234567890   \t   \t     \n");
        Performance performance1 = show1.getPerformance("15.08.2025 08:00");

        boolean buyingRes1 = visitor6.buyTicket(performance1, "2B");
//        System.out.println(buyingRes1);

        boolean buyingRes2 = visitor6.buyTicket(performance1, "1B");
//        System.out.println(buyingRes2);

        System.out.println(visitor6);

//        System.out.println(show1);
//        System.out.println();
    }
}