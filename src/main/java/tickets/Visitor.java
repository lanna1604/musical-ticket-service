package tickets;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Visitor {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    private String name;
    private String phone;
    ArrayList<Ticket> tickets = new ArrayList<>();

    Visitor(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    String getName() {
        return this.name;
    }

    String getPhone() {
        return this.phone;
    }

    private void setName(String name) {
        String trimmed = StringUtils.trimToNull(name);

        if (trimmed == null || trimmed.length() < 2) {
            throw new IllegalArgumentException(
                    String.format("Invalid name '%s'. Must contain at least 2 characters", name)
            );
        }

        this.name = trimmed;
    }

    private void setPhone(String phone) {
        String trimmed = StringUtils.trimToNull(phone);

        if (trimmed == null || !PHONE_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException(
                    String.format("Invalid phone '%s'. Must contain exactly 10 digits", phone)
            );
        }

        this.phone = trimmed;
    }

    boolean buyTicket(Performance performance, String place) {
        Ticket ticket = performance.getTicket(place);

        if (ticket.bookFor(this)) {
            tickets.add(ticket);

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Visitor {" +
                "name = '" + this.name + '\'' +
                ", phone = '" + this.phone + '\'' +
                ", tickets = " + this.tickets +
                '}';
    }
}
