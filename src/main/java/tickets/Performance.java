package tickets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Performance {
    public final static String START_AT_PATTERN = "dd.MM.yyyy HH:mm";
    private final static DateTimeFormatter START_AT_FORMATTER = DateTimeFormatter.ofPattern(START_AT_PATTERN);

    private Hall hall;
    private LocalDateTime startAt;
    private double ticketPrice;
    ArrayList<Ticket> tickets;

    Performance(Hall hall, String dateTime, double ticketPrice) {
        this.hall = hall;
        setStartAt(dateTime);
        setTicketPrice(ticketPrice);

        this.tickets = hall.generateTickets(this.ticketPrice);
    }

    private void setStartAt(String dateTime) {
        try {
            LocalDateTime startAt = LocalDateTime.parse(dateTime, START_AT_FORMATTER);

            if (startAt.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("Invalid value. Start time can't be in the past.");
            }

            this.startAt = startAt;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use pattern: " + START_AT_PATTERN);
        }
    }

    private void setTicketPrice(double ticketPrice) {
        if (ticketPrice < 0) {
            throw new IllegalArgumentException("Invalid value. Ticket price can't be negative.");
        }

        this.ticketPrice = ticketPrice;
    }

    Ticket getTicket(String place) {
        for (Ticket ticket : tickets) {
            if (ticket.getPlace().equals(place)) {
                return ticket;
            }
        }

        throw new IllegalArgumentException("This place doesn't exist. Please check data.");
    }

    String getStartAt() {
        return startAt.format(START_AT_FORMATTER);
    }

    @Override
    public String toString() {
        return "Performance {" +
                "hall = " + hall +
                ", startAt = " + startAt +
                ", ticketPrice = " + ticketPrice +
                ", tickets = " + tickets +
                '}';
    }
}
