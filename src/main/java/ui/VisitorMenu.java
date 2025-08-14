package ui;

import tickets.TicketService;
import tickets.Visitor;

import java.util.List;

public class VisitorMenu extends Menu {
    public VisitorMenu(TicketService service) {
        super(service);
    }

    public void start() {
        String choice;

        do {
            printMenuHeader("Visitor Menu");
            printMenuOptions("Please select an action", List.of(
                    "Back to Main Menu",
                    "Create a new Visitor",
                    "Select an existing Visitor"
            ));
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "0" -> {}
                case "1" -> createVisitor();
                case "2" -> {
                    Visitor visitor = selectExistingVisitor();

                    if (visitor != null) {
                        new ExistingVisitorMenu(service, visitor).start();
                    }
                }
                default -> printError("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }

    private void createVisitor() {
        printActionHeader("Creation of Visitor");

        while (true) {
            try {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Phone: ");
                String phone = scanner.nextLine();

                Visitor visitor = service.createVisitor(name, phone);

                printCreationSuccess(visitor);
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private Visitor selectExistingVisitor() {
        if (service.getVisitors().isEmpty()) {
            printError("No visitors found. Please create a new Visitor first!");
            return null;
        }

        printActionHeader("Select Existing Visitor");

        try {
            System.out.print("Please enter your phone number to find your account: ");
            return service.getVisitorByPhone(scanner.nextLine());
        } catch (Throwable e) {
            printError(e.getMessage());
        }

        return null;
    }
}