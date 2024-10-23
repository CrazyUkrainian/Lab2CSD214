package Interface;

import java.util.Date;


public abstract class Magazine extends Publication {
    private int orderQty;
    private Date currIssue;
    private String isbn13; // Add isbn13 as an attribute

    // Default constructor
    public Magazine(String title, double price, int copies, int orderQty) {
        this.currIssue = new Date(); // Set to the current date by default
    }

    // Updated constructor to accept isbn13
    public Magazine(String title, double price, int copies, int orderQty, String isbn13) {
        super(title, price, copies); // Call to the Publication constructor
        this.orderQty = orderQty;
        this.currIssue = new Date(); // Initialize currIssue to the current date by default
        this.isbn13 = isbn13; // Set isbn13
    }

    public Magazine(String title, double price, int quantity, String isbn13) {
        super(title, price, quantity); // Call to the Publication constructor
        this.currIssue = new Date(); // Initialize currIssue to the current date by default
        this.isbn13 = isbn13; // Set isbn13
    }

    @Override
    public void edit() {
        // Logic to edit magazine details
        System.out.println("Editing Magazine details:");
        setTitle(getInputString("Enter new title: "));
        setPrice(getInputDouble("Enter new price: "));
        setCopies(getInputInt("Enter new number of copies: "));
        setOrderQty(getInputInt("Enter new order quantity: "));
        currIssue = getInputDate("Enter new current issue date (yyyy-mm-dd): ");
        isbn13 = getInputString("Enter new ISBN13: "); // Capture new ISBN13 input
    }

    @Override
    public void initialize() {
        // Logic to initialize a new magazine
        System.out.println("Initializing a new Magazine:");
        setTitle(getInputString("Enter title: "));
        setPrice(getInputDouble("Enter price: "));
        setCopies(getInputInt("Enter number of copies: "));
        setOrderQty(getInputInt("Enter order quantity: "));
        currIssue = getInputDate("Enter current issue date (yyyy-mm-dd): ");
        isbn13 = getInputString("Enter ISBN13: "); // Capture ISBN13 input
    }

    @Override
    public String toString() {
        return super.toString() + ", Order Qty: " + orderQty + ", Current Issue: " + currIssue + ", ISBN13: " + isbn13;
    }

    // Getters and Setters for orderQty, currIssue, and isbn13
    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
}
