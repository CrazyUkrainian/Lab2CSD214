/*package Interface;

public abstract class DiscMag extends Magazine {
    private boolean hasDisc;

    // Default constructor
    public DiscMag() {
        super(title, price, copies, orderQty); // Call the superclass constructor
        this.hasDisc = false; // Default value
    }

    // Constructor with the 'hasDisc' parameter
    public DiscMag(boolean hasDisc) {
        super(title, price, copies, orderQty); // Call the superclass constructor
        this.hasDisc = hasDisc;
    }

    // Constructor with parameters for title, price, copies, and hasDisc
    public DiscMag(String title, double price, int copies, boolean hasDisc, int orderQty) {
        super(title, price, copies, orderQty); // This should now work correctly
        this.hasDisc = hasDisc;
    }


    @Override
    public void edit() {
        // Logic to edit a DiscMag's details
        System.out.println("Editing Disc Magazine details:");
        setTitle(getInputString("Enter new title: "));
        setPrice(getInputDouble("Enter new price: "));
        setCopies(getInputInt("Enter new number of copies: "));
        setOrderQty(getInputInt("Enter new order quantity: "));
        setHasDisc(getInputBoolean("Does it have a disc? (true/false): "));
    }

    @Override
    public void initialize() {
        // Logic to initialize a new DiscMag
        System.out.println("Initializing a new Disc Magazine:");
        setTitle(getInputString("Enter title: "));
        setPrice(getInputDouble("Enter price: "));
        setCopies(getInputInt("Enter number of copies: "));
        setOrderQty(getInputInt("Enter order quantity: "));
        setHasDisc(getInputBoolean("Does it have a disc? (true/false): "));
    }


    @Override
    public String toString() {
        return super.toString() + ", Has Disc: " + hasDisc;
    }

    // Getter and Setter for hasDisc
    public boolean hasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }
}
*/