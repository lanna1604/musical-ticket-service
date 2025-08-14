package ui;

import tickets.*;

import java.util.ArrayList;
import java.util.List;

public class ExistingVisitorMenu extends Menu {
    private final Visitor visitor;

    public ExistingVisitorMenu(TicketService service, Visitor visitor) {
        super(service);

        this.visitor = visitor;
    }

    public void start() {
        String choice;

        do {
            printMenuHeader("Existing Visitor Menu");
            System.out.println(YELLOW + "Visitor: " + this.visitor.getName() + RESET);

            printMenuOptions("Please select an action", List.of(
                    "Back to Visitor Menu",
                    "Buy a ticket",
                    "View my Tickets"
            ));
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "0" -> {
                }
                case "1" -> buyTicket();
                case "2" -> viewTickets();
                default -> printError("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }

    private void viewTickets() {
        ArrayList<Ticket> tickets = visitor.getTickets();

        System.out.print(YELLOW);
        if (tickets.isEmpty()) {
            System.out.println("\nYou don't have any tickets yet.");
        } else {
            System.out.println("\n--- Tickets ---");
            System.out.println(visitor.ticketsToString());
        }
        System.out.print(RESET);
    }

    private void buyTicket() {
        printActionHeader("Buying a ticket");

        try {
            MusicalShow show = selectShow();
            Performance performance = selectPerformance(show);
            String place = selectPlace(performance);

            Ticket ticket = visitor.buyTicket(performance, place);

            System.out.println(GREEN + "Seat booked successfully." + RESET);
        } catch (Throwable e) {
            printError(e.getMessage());
        }
    }

    private String selectPlace(Performance performance) {
        ArrayList<Ticket> tickets = performance.getTickets();
        int numberOfSeats = performance.getHall().getSeatsPerRow();

        System.out.println("\n--- Select Your Seat ---");

        int i = 1;
        for (Ticket ticket : tickets) {
            System.out.printf("%s%-6s%s%s",
                    ticket.isSold() ? RED : GREEN,
                    ticket.getPlace(),
                    (i++ % numberOfSeats == 0) ? "\n" : "",
                    RESET);
        }

        scanner.nextLine();
        System.out.print("Your choice: ");

        return scanner.nextLine().trim();
    }
}
