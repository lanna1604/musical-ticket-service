package ui;

import tickets.TicketService;

import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu {
    private final TicketService service;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(TicketService service) {
        this.service = service;
    }

    public void start() {
        String choice;

        do {
            printMenuHeader("Main Menu");
            printMenuOptions("Please select your role", List.of(
                    "Exit",
                    "Admin",
                    "Visitor"
            ));
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "0" -> System.out.println("Exiting...");
                case "1" -> new AdminMenu(service, scanner).start();
                case "2" -> new VisitorMenu(service, scanner).start();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }
}
