package tickets;

import org.apache.commons.lang3.StringUtils;

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

    private void setTitle(String title) {
        String trimmed = StringUtils.trimToNull(title);

        if (trimmed == null || trimmed.length() < 2) {
            throw new IllegalArgumentException(
                    String.format("Invalid name '%s'. Must contain at least 2 characters", title)
            );
        }

        this.title = trimmed;
    }

    Performance createPerformance(Hall hall, String dateTime, double ticketPrice) {
        Performance performance = new Performance(this, hall, dateTime, ticketPrice);
        performances.add(performance);

        return performance;
    }

    public ArrayList<Performance> getPerformances() {
        return performances;
    }

    @Override
    public String toString() {
        return "MusicalShow {" +
                "title = '" + title + '\'' +
                ", performances = " + performances +
                '}';
    }
}
