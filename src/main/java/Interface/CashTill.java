package Interface;

import java.text.DecimalFormat;

public class CashTill {
    private double runningTotal;
    private static CashTill instance;

    // Private constructor to prevent instantiation
    private CashTill() {
        this.runningTotal = 0;
    }

    // Thread-safe singleton instance retrieval
    public static synchronized CashTill getInstance() {
        if (instance == null) {
            instance = new CashTill();
        }
        return instance;
    }

    // Method to add to the total
    public void addToTotal(double amount) {
        if (amount > 0) {  // Ensure only positive amounts are added
            runningTotal += amount;
        } else {
            System.out.println("Cannot add a negative amount.");
        }
    }

    // Method to get the current total (getter)
    public double getTotal() {
        return runningTotal;
    }

    // Method to display the total formatted as currency
    public void showTotal() {
        DecimalFormat df = new DecimalFormat("$#.00"); // Format to two decimal places
        System.out.println("Total Cash in Till: " + df.format(runningTotal));
    }
}


