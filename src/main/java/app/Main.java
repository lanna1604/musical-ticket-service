package app;

import tickets.*;
import ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        if (args.length > 0 && args[0].equals("test")) {
            service.createTestData();
        }

        new MainMenu(service).start();
    }
}