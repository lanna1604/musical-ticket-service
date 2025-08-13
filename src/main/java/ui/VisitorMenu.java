package ui;

import tickets.TicketService;
import java.util.Scanner;

public class VisitorMenu {
    private final TicketService service;
    private final Scanner scanner;

    public VisitorMenu(TicketService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Visitor");
    }
}
