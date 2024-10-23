package Interface;

public abstract class Ticket extends Editable implements SaleableItem {
    private String description;
    private double price;
    private int quantity;

    public Ticket() {}

    public Ticket(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters for description, price, and quantity
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public short sellCopy() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Ticket sold: " + description);
        } else {
            System.out.println("No more tickets available.");
        }
        return 0;
    }

    @Override
    public void edit() {
        // Logic to edit ticket's details
        System.out.println("Editing ticket details:");
        setDescription(getInputString("Enter new description: "));
        setTicketPrice(getInputDouble("Enter new price: "));
        setQuantity(getInputInt("Enter new quantity: "));
    }

    @Override
    public void initialize() {
        // Logic to initialize a new ticket
        System.out.println("Initializing a new ticket:");
        setDescription(getInputString("Enter description: "));
        setTicketPrice(getInputDouble("Enter price: "));
        setQuantity(getInputInt("Enter quantity: "));
    }

    @Override
    public String toString() {
        return "Ticket: " + description + ", Price: " + price + ", Quantity: " + quantity;
    }
}
