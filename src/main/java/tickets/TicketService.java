package tickets;

import java.util.ArrayList;

// TODO - convert to Singleton
public class TicketService {
    private ArrayList<Hall> halls = new ArrayList<>();
    private ArrayList<MusicalShow> shows = new ArrayList<>();
    private ArrayList<Performance> performances = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public Hall createHall(String title, int numberOfRows, int seatsPerRow) {
        Hall hall = new Hall(title, numberOfRows, seatsPerRow);
        halls.add(hall);

        return hall;
    }

    public MusicalShow createMusicalShow(String title) {
        MusicalShow show = new MusicalShow(title);
        shows.add(show);

        return show;
    }

    public Performance createPerformance(MusicalShow show, Hall hall, String dateTime, double ticketPrice) {
        Performance performance = show.createPerformance(hall, dateTime, ticketPrice);
        performances.add(performance);

        return performance;
    }

    public Visitor createVisitor(String name, String phone) {
        Visitor visitor = new Visitor(name, phone);
        visitors.add(visitor);

        return visitor;
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public ArrayList<MusicalShow> getShows() {
        return shows;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public Visitor getVisitorByPhone(String phone) {
        for (Visitor visitor : visitors) {
            if (visitor.getPhone().equals(phone)) {
                return visitor;
            }
        }

        throw new IllegalArgumentException("Visitor with this phone doesn't exist. Please check data.");
    }

    public void createTestData() {
        Hall hall1 = this.createHall("Hall_1", 4, 3);
        Hall hall2 = this.createHall("Hall_2", 2, 5);
        Hall hall3 = this.createHall("Hall_3", 5, 10);
        Hall hall4 = this.createHall("Big_Hall", 15, 26);

        MusicalShow show1 = this.createMusicalShow("Show_1");
        MusicalShow show2 = this.createMusicalShow("Show_2");

        Performance performance1_1 = this.createPerformance(show1, hall2, "20.08.2025 18:30", 199.99);
        Performance performance1_2 = this.createPerformance(show1, hall3, "20.08.2025 12:00", 175);
        Performance performance2_1 = this.createPerformance(show2, hall1, "18.08.2025 20:00", 300);
        Performance performance2_2 = this.createPerformance(show2, hall2, "20.08.2025 20:00", 300);
        Performance performance2_3 = this.createPerformance(show2, hall1, "30.08.2025 20:00", 300);
        Performance performance2_4 = this.createPerformance(show2, hall4, "25.08.2025 21:30", 250);

        Visitor visitor1 = this.createVisitor("James Gosling", "1234567890");
        Visitor visitor2 = this.createVisitor("Darth Vader", "9876543210");
        Visitor visitor3 = this.createVisitor("Santa Claus", "9999999999");

        visitor1.buyTicket(performance1_1, "1A");
        visitor1.buyTicket(performance1_1, "1B");
        visitor1.buyTicket(performance2_3, "2C");

        visitor2.buyTicket(performance1_1, "2B");
    }
}
