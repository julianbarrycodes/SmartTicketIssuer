public enum TicketType {
    SINGLE_REDUCED(2.20),
    SINGLE_FULL(3.20),
    DAY_REDUCED(5.50),
    DAY_FULL(7.90);

    private final double price;

    TicketType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
