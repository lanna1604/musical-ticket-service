package ui;

import tickets.TicketService;
import java.util.Scanner;

public class AdminMenu {
    private final TicketService service;
    private final Scanner scanner;

    public AdminMenu(TicketService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Admin");
    }
}
