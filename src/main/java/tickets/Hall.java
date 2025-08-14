package tickets;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Hall {
    private String title;
    private int numberOfRows;
    private int seatsPerRow;

    private enum RowLabel {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
    }

    public Hall(String title, int numberOfRows, int seatsPerRow) {
        setTitle(title);
        setNumberOfRows(numberOfRows);
        setSeatsPerRow(seatsPerRow);
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        String trimmed = StringUtils.trimToNull(title);

        if (trimmed == null || trimmed.length() < 2) {
            throw new IllegalArgumentException(
                    String.format("Invalid name '%s'. Must contain at least 2 characters", title)
            );
        }

        this.title = trimmed;
    }

    private void setNumberOfRows(int numberOfRows) throws IllegalArgumentException {
        if (numberOfRows < 1) {
            throw new IllegalArgumentException("Invalid value. Minimum value for number of rows is 1.");
        }
        this.numberOfRows = numberOfRows;
    }

    private void setSeatsPerRow(int seatsPerRow) throws IllegalArgumentException {
        int maxRowValue = RowLabel.values().length;

        if (seatsPerRow < 1 || seatsPerRow > maxRowValue) {
            throw new IllegalArgumentException("Invalid value. The valid range of seats in a row is 1 to " + maxRowValue);
        }

        this.seatsPerRow = seatsPerRow;
    }

    ArrayList<Ticket> generateTickets(Performance performance) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        RowLabel[] rowLabels = RowLabel.values();

        for (int row = 1; row <= numberOfRows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                String place = "" + row + rowLabels[seat];
                tickets.add(new Ticket(performance, place));
            }
        }

        return tickets;
    }

    @Override
    public String toString() {
        return "Hall {" +
                "title = " + this.title +
                ", numberOfRows = " + this.numberOfRows +
                ", seatsPerRow = " + this.seatsPerRow +
                '}';
    }
}
