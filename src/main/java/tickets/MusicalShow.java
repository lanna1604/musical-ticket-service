package tickets;

import java.util.ArrayList;

public class MusicalShow {
    private String title;
    ArrayList<Performance> performances = new ArrayList<>();

    public MusicalShow(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        //TODO: validation
        this.title = title;
    }

    public void createPerformance(Hall hall, String dateTime, double ticketPrice) {
        Performance performance = new Performance(hall, dateTime, ticketPrice);
        performances.add(performance);
    }

    public Performance getPerformance(String dateTime) {
        for (Performance performance : performances) {
            if (performance.getStartAt().equals(dateTime)) {
                return performance;
            }
        }

        throw new IllegalArgumentException("Performance with this start date doesn't exist. Please check data.");
    }

    @Override
    public String toString() {
        return "MusicalShow {" +
                "title = '" + title + '\'' +
                ", performances = " + performances +
                '}';
    }
}
