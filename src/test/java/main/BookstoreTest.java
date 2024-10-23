package main;

import Interface.Magazine;
import Interface.Pencil;
import Interface.SaleableItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookstoreTest {

    private Bookstore bookstore;
    private SaleableItem pencil;
    private SaleableItem magazine;

    @BeforeEach
    void setUp() {
        // Initialize the Bookstore and mock items
        bookstore = new Bookstore();
        bookstore.saleableItems = new ArrayList<>();

        // Mock SaleableItems (Assuming Pencil and Magazine classes implement SaleableItem)
        pencil = new Pencil("BrandA", "TitleA", 2.50, 10, "1234567890") {
            @Override
            public Double getBrand() {
                return 0.0; // Simplified for test
            }
        };

        magazine = new Magazine("Tech Mag", 5.00, 15, "Tech", 20) {
            @Override
            public Double getBrand() {
                return 0.0;
            }
        };
    }

    @Test
    void addItem() {
        // Add an item and verify the size of saleableItems list increases
        bookstore.addItem(pencil);
        assertEquals(1, bookstore.saleableItems.size());
        assertTrue(bookstore.saleableItems.contains(pencil));
    }

    @Test
    void removeItem() {
        // Add the item first, then remove it, and verify the list size decreases
        bookstore.addItem(magazine);
        bookstore.removeItem(magazine);
        assertEquals(0, bookstore.saleableItems.size());
    }



}
