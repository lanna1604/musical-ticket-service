package ui;

import tickets.TicketService;
import java.util.Scanner;

public class MainMenu {
    private final TicketService service;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(TicketService service) {
        this.service = service;
    }

    public void start() {
        String choice;

        do {
            System.out.println();
            System.out.println("=== Main Menu ===");
            System.out.println("Please select your role:");
            System.out.println("(A)dmin");
            System.out.println("(V)isitor");
            System.out.println("(E)xit");

            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a" -> new AdminMenu(service, scanner).start();
                case "v" -> new VisitorMenu(service, scanner).start();
                case "e" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("e"));
    }
}
