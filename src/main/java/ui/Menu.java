package ui;

import tickets.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// TODO - make renderMenu with header, options and callbacks
// TODO - refactor all select...() into a universal method
public class Menu {
    // ANSI colors
    protected static final String RESET = "\u001B[0m";
    protected static final String RED = "\u001B[31m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String CYAN = "\u001B[36m";

    protected final TicketService service;
    protected final Scanner scanner = new Scanner(System.in);

    public Menu(TicketService service) {
        this.service = service;
    }

    protected void printMenuHeader(String menuTitle) {
        System.out.println(CYAN + "\n=== " + menuTitle + " ===" + RESET);
    }

    protected void printActionHeader(String actionTitle) {
        System.out.println(CYAN + "\n--- " + actionTitle + " ---" + RESET);
    }

    protected void printMenuOptions(String header, List<String> options) {
        System.out.println(header + ":");

        int key = 0;
        for (String option : options) {
            System.out.print(CYAN + key++ + RESET);
            System.out.println(" - " + option);
        }
    }

    protected void printCreationSuccess(Object entity) {
        System.out.println(GREEN + "Item created successfully." + RESET);
        System.out.println(YELLOW + entity + RESET);
    }

    protected void printError(String message) {
        System.out.println(RED + "Error: " + message + RESET);
    }

    protected MusicalShow selectShow() {
        MusicalShow show;

        ArrayList<MusicalShow> shows = service.getShows();
        List<String> showTitles = shows.stream()
                .map(MusicalShow::getTitle)
                .toList();

        while (true) {
            try {
                printMenuOptions("\nPlease select a Musical Show", showTitles);
                System.out.print("Your choice: ");
                show = shows.get(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                printError("Please enter a valid number.");
                scanner.nextLine();
            } catch (Throwable e) {
                printError("Item not found. Please try again.");
            }
        }

        return show;
    }

    protected Hall selectHall() {
        Hall hall;

        ArrayList<Hall> halls = service.getHalls();
        List<String> hallsTitles = halls.stream()
                .map(Hall::getTitle)
                .toList();

        while (true) {
            try {
                printMenuOptions("\nPlease select a Hall", hallsTitles);
                System.out.print("Your choice: ");
                hall = halls.get(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                printError("Please enter a valid number.");
                scanner.nextLine();
            } catch (Throwable e) {
                printError("Item not found. Please try again.");
            }
        }

        return hall;
    }

    protected Performance selectPerformance(MusicalShow show) {
        Performance performance;

        ArrayList<Performance> performances = show.getPerformances();
        List<String> titles = performances.stream()
                .map(Performance::toString)
                .toList();

        while (true) {
            try {
                System.out.println();
                printMenuOptions("Please select a Performance", titles);
                System.out.print("Your choice: ");
                performance = performances.get(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                printError("Please enter a valid number.");
                scanner.nextLine();
            } catch (Throwable e) {
                printError("Item not found. Please try again.");
            }
        }

        return performance;
    }
}
