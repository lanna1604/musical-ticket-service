package tickets;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Performance {
    public final static String START_AT_PATTERN = "dd.MM.yyyy HH:mm";
    private final static DateTimeFormatter START_AT_FORMATTER = DateTimeFormatter.ofPattern(START_AT_PATTERN);

    private MusicalShow musicalShow;
    private Hall hall;
    private LocalDateTime startAt;
    private double ticketPrice;
    private ArrayList<Ticket> tickets;

    Performance(MusicalShow musicalShow, Hall hall, String dateTime, double ticketPrice) {
        this.musicalShow = musicalShow;
        this.hall = hall;
        setStartAt(dateTime);
        setTicketPrice(ticketPrice);

        this.tickets = hall.generateTickets(this);
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
        String trimmedPlace = StringUtils.trimToNull(place);

        for (Ticket ticket : tickets) {
            if (ticket.getPlace().equals(trimmedPlace)) {
                return ticket;
            }
        }

        throw new IllegalArgumentException("This place doesn't exist. Please check data.");
    }

    public MusicalShow getMusicalShow() {
        return musicalShow;
    }

    public Hall getHall() {
        return this.hall;
    }

    String getStartAt() {
        return this.startAt.format(START_AT_FORMATTER);
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    private ArrayList<Ticket> getAvailableTickets() { // TODO - refactoring using generics
        ArrayList<Ticket> availableTickets = new ArrayList<>();

        for (Ticket ticket : this.tickets) {
            if (!ticket.isSold()) {
                availableTickets.add(ticket);
            }
        }

        return availableTickets;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return String.format("%s  |  del: %s  |  Hall: %s  |  Prise: %.2f€  |  %d of %d seat(s) available",
                this.getStartAt(),
                this.musicalShow.getTitle(),
                this.hall.getTitle(),
                this.ticketPrice,
                getAvailableTickets().toArray().length,
                this.tickets.toArray().length
        );
    }
}
