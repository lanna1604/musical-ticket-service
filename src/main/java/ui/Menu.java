package ui;

import java.util.List;

public class Menu {
    // ANSI colors
    protected static final String RESET = "\u001B[0m";
    protected static final String RED = "\u001B[31m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String CYAN = "\u001B[36m";

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
}
