package ui;

import tickets.Hall;
import tickets.MusicalShow;
import tickets.Performance;
import tickets.TicketService;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                System.out.print("Title: ");
                String title = scanner.nextLine().trim();

                System.out.print("Number of rows: ");
                int numberOfRows = Integer.parseInt(scanner.nextLine());

                System.out.print("Seats per row: ");
                int seatsPerRow = Integer.parseInt(scanner.nextLine());

                Hall hall = service.createHall(title, numberOfRows, seatsPerRow);

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
                MusicalShow show = selectShow();
                Hall hall = selectHall();
                scanner.nextLine();

                System.out.print("Enter performance date and time (" + Performance.START_AT_PATTERN + "): ");
                String dateTime = scanner.nextLine();

                System.out.print("Enter ticket price: ");
                double price = Double.parseDouble(scanner.nextLine());

                show.createPerformance(hall, dateTime, price);
                System.out.println(GREEN + "Performance created successfully." + RESET);
                System.out.println(YELLOW + show + RESET);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + "\nPlease try again." + RESET);
            }
        }
    }

    private MusicalShow selectShow() {
        MusicalShow show;

        ArrayList<MusicalShow> shows = service.getShows();
        List<String> showTitles = shows.stream()
                .map(MusicalShow::getTitle)
                .toList();

        while (true) {
            try {
                printMenuOptions("Please select a Musical Show", showTitles);
                System.out.print("Your choice: ");
                show = shows.get(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Please enter a valid number." + RESET);
                scanner.nextLine();
            } catch (Throwable e) {
                System.out.println(RED + "Item not found. Please try again." + RESET);
            }
        }

        return show;
    }

    private Hall selectHall() {
        Hall hall;

        ArrayList<Hall> halls = service.getHalls();
        List<String> hallsTitles = halls.stream()
                .map(Hall::getTitle)
                .toList();

        while (true) {
            try {
                printMenuOptions("Please select a Hall", hallsTitles);
                System.out.print("Your choice: ");
                hall = halls.get(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Please enter a valid number." + RESET);
                scanner.nextLine();
            } catch (Throwable e) {
                System.out.println(RED + "Item not found. Please try again." + RESET);
            }
        }

        return hall;
    }
}
