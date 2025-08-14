package ui;

import tickets.TicketService;

import java.util.List;

public class MainMenu extends Menu {
    public MainMenu(TicketService service) {
        super(service);
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
                case "1" -> new AdminMenu(service).start();
                case "2" -> new VisitorMenu(service).start();
                default -> printError("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }
}
