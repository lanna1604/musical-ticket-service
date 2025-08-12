package tickets;

import java.util.ArrayList;

class Hall {
    private int numberOfRows;
    private int seatsPerRow;

    private enum RowLabel {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
    }

    Hall(int numberOfRows, int seatsPerRow) throws RuntimeException {  // TODO: ???
        setNumberOfRows(numberOfRows);
        setSeatsPerRow(seatsPerRow);
    }

    private void setNumberOfRows(int numberOfRows) throws RuntimeException {
        if (numberOfRows < 1) {
            throw new RuntimeException("Invalid value. Minimum value for number of rows is 1.");
        }
        this.numberOfRows = numberOfRows;
    }

    private void setSeatsPerRow(int seatsPerRow) throws RuntimeException {
        int maxRowValue = RowLabel.values().length;

        if (seatsPerRow < 1 || seatsPerRow > maxRowValue) {
            throw new RuntimeException("Invalid value. The valid range of seats in a row is 1 to " + maxRowValue);
        }

        this.seatsPerRow = seatsPerRow;
    }

    ArrayList<Ticket> generateTickets(double price) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        RowLabel[] rowLabels = RowLabel.values();

        for (int row = 1; row <= numberOfRows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                String place = "" + row + rowLabels[seat];
                tickets.add(new Ticket(place, price));
            }
        }

        return tickets;
    }

    @Override
    public String toString() {
        return "Hall {" +
                "numberOfRows = " + numberOfRows +
                ", seatsPerRow = " + seatsPerRow +
                '}';
    }
}
