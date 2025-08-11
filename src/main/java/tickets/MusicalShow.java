package tickets;

import java.util.ArrayList;

public class MusicalShow {
    private String title;
    private double ticketPrice;
    private ArrayList<Performance> performances;

    MusicalShow(String title) {
        setTitle(title);
    }

    MusicalShow(String title, double ticketPrice) {
        this(title);
        setTicketPrice(ticketPrice);
    }

    protected void setTitle(String title) {
        //TODO: validation
        this.title = title;
    }

    protected void setTicketPrice(double ticketPrice) {
        //TODO: validation
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "MusicalShow {" +
                "title = '" + title + '\'' +
                ", ticketPrice = " + ticketPrice +
                ", performances = " + performances +
                '}';
    }
}
