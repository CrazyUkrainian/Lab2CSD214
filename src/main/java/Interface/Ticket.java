package Interface;

public abstract class Ticket extends Editable implements SaleableItem {
    private String description;
    private double price;

    public Ticket() {}

    public Ticket(String description, double price) {
        this.description = description;
        this.price = price;
    }

    // Getters and Setters for description and price
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTicketPrice() {
        return price;
    }

    public void setTicketPrice(double price) {
        this.price = price;
    }

    @Override
    public void edit() {
        // Logic to edit ticket's details
        System.out.println("Editing ticket details:");
        setDescription(getInputString("Enter new description: "));
        setTicketPrice(getInputDouble("Enter new price: "));
        // Add any other fields relevant to Ticket if necessary
    }

    @Override
    public void initialize() {
        // Logic to initialize a new ticket
        System.out.println("Initializing a new ticket:");
        setDescription(getInputString("Enter description: "));
        setTicketPrice(getInputDouble("Enter price: "));
        // Add any other fields relevant to Ticket if necessary
    }


    @Override
    public void sellCopy() {
        System.out.println("Ticket sold: " + description);
    }

    @Override
    public String toString() {
        return "Ticket: " + description + ", Price: " + price;
    }
}
