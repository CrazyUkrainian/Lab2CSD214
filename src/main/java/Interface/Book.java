package Interface;

public abstract class Book extends Publication {
    private String author;

    // Default constructor (not usually needed, consider removing it)
    public Book() {
        super(); // Calls the parent constructor
    }

    // Constructor with all parameters
    public Book(String title, String author, double price, int copies, String ISBN10) {
        super(title, price, copies);
        this.author = author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    @Override
    public void edit() {
        // Logic to edit a book's details
        System.out.println("Editing book details:");
        setTitle(getInputString("Enter new title: "));
        setPrice(getInputDouble("Enter new price: "));
        setCopies(getInputInt("Enter new number of copies: "));
        setAuthor(getInputString("Enter new author: "));
        setISBN10(getInputString("Enter new ISBN10: "));
    }

    @Override
    public void initialize() {
        // Logic to initialize a new book
        System.out.println("Initializing a new book:");
        setTitle(getInputString("Enter title: "));
        setPrice(getInputDouble("Enter price: "));
        setCopies(getInputInt("Enter number of copies: "));
        setAuthor(getInputString("Enter author: "));
        setISBN10(getInputString("Enter ISBN10: "));
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
