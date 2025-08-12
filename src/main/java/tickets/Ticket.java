package tickets;

class Ticket {
    private final String place;
    private double price;
    private Visitor visitor;

    Ticket(String place, double price) {
        this.place = place;
        setPrice(price);
    }

    String getPlace() {
        return this.place;
    }

    private void setPrice(double price) throws RuntimeException {
        if (price < 0) {
            throw new RuntimeException("Invalid value. Price can't be negative.");
        }

        this.price = price;
    }

    boolean isSold() {
        return this.visitor != null;
    }

    boolean bookFor(Visitor visitor) {
        if (!this.isSold()) {
            this.visitor = visitor;

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "place = '" + this.place + '\'' +
                ", price = " + this.price +
                ", visitor = " + visitorToString() +
                '}';
    }

    private String visitorToString() {
        return isSold() ?
                "Visitor {name = '" + this.visitor.getName() + "', phone = '" + visitor.getPhone() + "'}" :
                "null";
    }
}
