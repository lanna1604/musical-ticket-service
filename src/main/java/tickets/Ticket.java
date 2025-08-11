package tickets;

public class Ticket {
    private String newTicketId;
    private Visitor visitor;

    public Ticket(String newTicketId) {
        this.newTicketId = newTicketId;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "newTicketId = '" + newTicketId + '\'' +
                ", visitor = " + visitor +
                '}';
    }
}
