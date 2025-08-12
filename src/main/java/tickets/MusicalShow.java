package tickets;

import java.util.ArrayList;

class MusicalShow {
    String title;
    ArrayList<Performance> performances = new ArrayList<>();

    MusicalShow(String title) {
        setTitle(title);
    }

    void setTitle(String title) {
        //TODO: validation
        this.title = title;
    }

    void createPerformance(Hall hall, String dateTime, double ticketPrice) {
        Performance performance = new Performance(hall, dateTime, ticketPrice);
        performances.add(performance);
    }

    Performance getPerformance(String dateTime) {
        for (Performance performance : performances) {
            if (performance.getStartAt().equals(dateTime)) {
                return performance;
            }
        }

        throw new RuntimeException("Performance with this start date doesn't exist. Please check data.");
    }

    @Override
    public String toString() {
        return "MusicalShow {" +
                "title = '" + title + '\'' +
                ", performances = " + performances +
                '}';
    }
}
