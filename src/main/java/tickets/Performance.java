package tickets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Performance {
    final static DateTimeFormatter START_AT_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

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

    private void setStartAt(String dateTime) throws RuntimeException {
        LocalDateTime startAt = LocalDateTime.parse(dateTime, START_AT_FORMATTER);

        if (startAt.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Invalid value. Start time can't be in the past.");
        }

        this.startAt = startAt;
    }

    private void setTicketPrice(double ticketPrice) {
        if (ticketPrice < 0) {
            throw new RuntimeException("Invalid value. Ticket price can't be negative.");
        }

        this.ticketPrice = ticketPrice;
    }

    Ticket getTicket(String place) {
        for (Ticket ticket : tickets) {
            if (ticket.getPlace().equals(place)) {
                return ticket;
            }
        }

        throw new RuntimeException("This place doesn't exist. Please check data.");
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
