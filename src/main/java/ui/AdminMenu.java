package ui;

import tickets.Hall;
import tickets.MusicalShow;
import tickets.TicketService;

import java.util.Scanner;

public class AdminMenu {
    private final TicketService service;
    private final Scanner scanner;

    // ANSI colors
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";

    public AdminMenu(TicketService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        String choice;

        do {
            System.out.println(CYAN + "\n=== Admin Menu ===" + RESET);
            System.out.println("Please select an action:");
            System.out.println("0. Back to Main Menu");
            System.out.println("1. Create Hall");
            System.out.println("2. Create Musical Show");
            System.out.println("3. Create Performance");

            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "0" -> {
                }
                case "1" -> createHall();
                case "2" -> createMusicalShow();
                case "3" -> createPerformance();
                default -> System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        } while (!choice.equals("0"));
    }

    private void createHall() {
        System.out.println(CYAN + "\n--- Creation of Hall ---" + RESET);

        while (true) {
            try {
                System.out.print("Number of rows: ");
                int numberOfRows = Integer.parseInt(scanner.nextLine());

                System.out.print("Seats per row: ");
                int seatsPerRow = Integer.parseInt(scanner.nextLine());

                Hall hall = service.createHall(numberOfRows, seatsPerRow);

                System.out.println(GREEN + "Hall created successfully.\n" + hall + RESET);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
            }
        }
    }

    private void createMusicalShow() {
        System.out.println(CYAN + "\n--- Creation of Musical Show ---" + RESET);

        while (true) {
            try {
                System.out.print("Title: ");
                String title = scanner.nextLine().trim();

                MusicalShow show = service.createMusicalShow(title);

                System.out.println(GREEN + "Musical Show created successfully.\n" + show + RESET);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
            }
        }


        System.out.println("createMusicalShow");
        String title = scanner.nextLine().trim();

        service.createMusicalShow(title);
    }

    private void createPerformance() {
        if (service.getHalls().isEmpty() || service.getShows().isEmpty()) {
            System.out.println(RED + "You need at least one Hall and one Musical Show first!" + RESET);
            return;
        }

        System.out.println(CYAN + "\n--- Creation of Performance ---" + RESET);

        while(true) {
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
