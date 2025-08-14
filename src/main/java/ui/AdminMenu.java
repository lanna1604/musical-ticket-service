package ui;

import tickets.Hall;
import tickets.MusicalShow;
import tickets.Performance;
import tickets.TicketService;

import java.util.List;

public class AdminMenu extends Menu {
    public AdminMenu(TicketService service) {
        super(service);
    }

    public void start() {
        String choice;

        do {
            printMenuHeader("Admin Menu");
            printMenuOptions("Please select an action", List.of(
                    "Back to Main Menu",
                    "Create Hall",
                    "Create Musical Show",
                    "Create Performance"
            ));
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "0" -> {}
                case "1" -> createHall();
                case "2" -> createMusicalShow();
                case "3" -> createPerformance();
                default -> printError("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }

    private void createHall() {
        printActionHeader("Creation of Hall");

        while (true) {
            try {
                System.out.print("Title: ");
                String title = scanner.nextLine().trim();

                System.out.print("Number of rows: ");
                int numberOfRows = Integer.parseInt(scanner.nextLine());

                System.out.print("Seats per row: ");
                int seatsPerRow = Integer.parseInt(scanner.nextLine());

                Hall hall = service.createHall(title, numberOfRows, seatsPerRow);

                printCreationSuccess(hall);
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private void createMusicalShow() {
        printActionHeader("Creation of Musical Show");

        while (true) {
            try {
                System.out.print("Title: ");
                String title = scanner.nextLine().trim();

                MusicalShow show = service.createMusicalShow(title);

                printCreationSuccess(show);
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private void createPerformance() {
        if (service.getHalls().isEmpty() || service.getShows().isEmpty()) {
            printError("You need at least one Hall and one Musical Show first!");
            return;
        }

        printActionHeader("Creation of Performance");

        while (true) {
            try {
                MusicalShow show = selectShow();
                Hall hall = selectHall();
                scanner.nextLine();

                System.out.print("Enter performance date and time (" + Performance.START_AT_PATTERN + "): ");
                String dateTime = scanner.nextLine();

                System.out.print("Enter ticket price: ");
                double price = Double.parseDouble(scanner.nextLine());

                Performance performance = service.createPerformance(show, hall, dateTime, price);

                printCreationSuccess(performance);
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
