package tickets;

import java.util.ArrayList;

public class TicketService {
    private ArrayList<Hall> halls = new ArrayList<>();
    private ArrayList<MusicalShow> shows = new ArrayList<>();
    private ArrayList<Performance> performances = new ArrayList<>();

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

    public Performance createPerformance(Hall hall, String dateTime, double ticketPrice) {
        Performance performance = new Performance(hall, dateTime, ticketPrice);
        performances.add(performance);

        return performance;
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public ArrayList<MusicalShow> getShows() {
        return shows;
    }

    public ArrayList<Performance> getPerformances() {
        return performances;
    }
}
