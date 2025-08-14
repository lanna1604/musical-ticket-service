package tickets;

public class Ticket {
    private final String place;
    private double price;
    private Performance performance;
    private Visitor visitor;

    Ticket(Performance performance, String place) {
        this.performance = performance;
        this.place = place;
        this.price = performance.getTicketPrice();
    }

    String getPlace() {
        return this.place;
    }

    MusicalShow getMusicalShow() {
        return this.performance.getMusicalShow();
    }

    boolean isSold() {
        return this.visitor != null;
    }

    boolean bookFor(Visitor visitor) {
        if (!this.isSold()) {
            this.visitor = visitor;

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%s  |  %s  |  %s  |  Place %s  |  Prise: %.2f€",
                this.getMusicalShow().getTitle(),
                this.performance.getStartAt(),
                this.performance.getHall().getTitle(),
                this.place,
                this.price
        );
    }
}
