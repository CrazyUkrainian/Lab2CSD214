package Interface;

public abstract class Publication extends Editable implements SaleableItem {
    protected String title;
    protected double price;
    protected int copies;
    protected String ISBN10;


    // Constructor with parameters
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.ISBN10 = ISBN10;
    }

    public Publication() {

    }


    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }


    // Setter for copies
    public void setCopies(int copies) {
        this.copies = copies;
    }

    // Getter for copies
    public int getCopies() {
        return copies;
    }

    // Setter for ISBN10
    public void setISBN10(String ISBN10) {
        this.ISBN10 = ISBN10;
    }

    // Getter for ISBN10
    public String getISBN10() {
        return ISBN10;
    }

    // Method to sell a copy
    public void sellCopy() {
        if (copies > 0) {
            copies--;
        } else {
            System.out.println("Out of stock.");
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if they are the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        Publication that = (Publication) obj;
        return Double.compare(that.price, price) == 0 &&
                title.equals(that.title) &&
                ISBN10.equals(that.ISBN10);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ISBN10.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Price: %.2f, ISBN10: %s, Copies: %d", title, price, ISBN10, copies);
    }
}
