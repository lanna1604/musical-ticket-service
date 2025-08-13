package ui;

import tickets.Hall;
import tickets.MusicalShow;
import tickets.TicketService;

import java.util.List;
import java.util.Scanner;

public class AdminMenu extends Menu {
    private final TicketService service;
    private final Scanner scanner;

    public AdminMenu(TicketService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
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
                default -> System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        } while (!choice.equals("0"));
    }

    private void createHall() {
        printActionHeader("Creation of Hall");

        while (true) {
            try {
                System.out.print("Number of rows: ");
                int numberOfRows = Integer.parseInt(scanner.nextLine());

                System.out.print("Seats per row: ");
                int seatsPerRow = Integer.parseInt(scanner.nextLine());

                Hall hall = service.createHall(numberOfRows, seatsPerRow);

                System.out.println(GREEN + "Hall created successfully." + RESET);
                System.out.println(YELLOW + hall + RESET);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
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

                System.out.println(GREEN + "Musical Show created successfully." + RESET);
                System.out.println(YELLOW + show + RESET);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
            }
        }
    }

    private void createPerformance() {
        if (service.getHalls().isEmpty() || service.getShows().isEmpty()) {
            System.out.println(RED + "You need at least one Hall and one Musical Show first!" + RESET);
            return;
        }

        printActionHeader("Creation of Performance");

        while (true) {
            try {
//                MusicalShow show1 = selectShow();
//        MusicalShow show1 = new MusicalShow("Test Show 1");
//        show1.createPerformance(hall1, "17.08.2025 12:35", 249.99);


                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
            }
        }
    }

//    private MusicalShow selectShow() {
//        System.out.println("Please select a Musical Show");
//    }
}
