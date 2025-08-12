package tickets;


public class Main {
    public static void main(String[] args) {
        Hall hall1 = new Hall(2, 3);
//        System.out.println(hall1);

        MusicalShow show1 = new MusicalShow("Test Show 1");
        show1.createPerformance(hall1, "17.08.2025 12:35", 249.99);
        show1.createPerformance(hall1, "15.08.2025 08:00", 200);

//        Visitor visitor5 = new Visitor(null, "1234567890   \t   \t     \n");
//        Visitor visitor4 = new Visitor("  ", "123456789   \t   \t     \n");
        Visitor visitor6 = new Visitor("   \tJames Gosling     \n", "1234567890   \t   \t     \n");
//        Visitor visitor1 = new Visitor("James Gosling", 9999999999);
        System.out.println(visitor6);
        System.out.println();

        Performance performance1 = show1.getPerformance("15.08.2025 08:00");
        Ticket ticket1 = performance1.getTicket("2B");
//        System.out.println(performance1);

        System.out.println(ticket1);
        System.out.println(ticket1.isSold());
        System.out.println();

        ticket1.bookFor(visitor6);
        System.out.println(ticket1);

//        System.out.println(show1);
//        System.out.println();
    }
}