package Interface;

public abstract class Pencil extends Publication {
    private String brand;

    // Constructor with brand, title, price, copies, and ISBN10
    public Pencil(String brand, String title, double price, int copies, String ISBN10) {
        super(title, price, copies); // Call to Publication constructor
        this.brand = brand;
    }

    // Optional constructor with a default price
    public Pencil(String brand, String title, int copies, String ISBN10) {
        this(brand, title, 0.5, copies, ISBN10); // Call the other constructor with default price
    }

    // Getter for brand
    public String getPencilBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public short sellCopy() {
        super.sellCopy(); // Call the sellCopy from Publication
        System.out.println("Pencil sold: " + brand);
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Pencil: %s, %s", brand, super.toString()); // Include Publication details
    }

    @Override
    public void edit() {
        // Logic to edit pencil’s details
        System.out.println("Editing pencil details:");
        setBrand(getInputString("Enter new brand: "));
        setTitle(getInputString("Enter new title: "));
        setPrice(getInputDouble("Enter new price: "));
        setCopies(getInputInt("Enter new number of copies: "));
        setISBN10(getInputString("Enter new ISBN10: "));
    }

    @Override
    public void initialize() {
        // Logic to initialize a new pencil
        System.out.println("Initializing a new pencil:");
        setBrand(getInputString("Enter brand: "));
        setTitle(getInputString("Enter title: "));
        setPrice(getInputDouble("Enter price: "));
        setCopies(getInputInt("Enter number of copies: "));
        setISBN10(getInputString("Enter ISBN10: "));
    }
}
