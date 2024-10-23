package main;

import Interface.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {
    private final ArrayList<SaleableItem> saleableItems = new ArrayList<>();
    private final CashTill cashTill = CashTill.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    private void addBook() {
        System.out.print("Enter Author ('q' to quit): ");
        String author = scanner.nextLine();
        if (author.equalsIgnoreCase("q")) return;

        System.out.print("Quantity to Order: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("ISBN10: ");
        String isbn10 = scanner.nextLine(); // Capture ISBN10 input

        // Create a new Book and add it to the bookstore
        SaleableItem book = new Book(title, author, price, quantity, isbn10) {

            @Override
            public Double getBrand() {
                return 0.0;
            }
        }; // Assuming Book implements SaleableItem
        addItem(book);
        System.out.println("Book added successfully.");
    }

    public void addItem(SaleableItem item) {
        saleableItems.add(item);
    }

    public void removeItem(SaleableItem item) {
        saleableItems.remove(item);
    }

    public void editItem(SaleableItem item) {
        if (item instanceof Editable) {
            ((Editable) item).edit();
        } else {
            System.out.println("Item is not editable.");
        }
    }

    public void viewItems() {
        if (saleableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        for (int i = 0; i < saleableItems.size(); i++) {
            System.out.println((i + 1) + ". " + saleableItems.get(i));
        }
    }

    public void sellItem(SaleableItem item) {
        item.sellCopy();
        cashTill.addToTotal(item.getPrice());
        System.out.println("Sold item: " + item);
    }

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        store.run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n-------------------------Main---------------------------------");
            System.out.println("1. Books");
            System.out.println("2. Tickets");
            System.out.println("3. Magazines"); // New option for Magazines
            System.out.println("4. Exit");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Choose an option: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mainChoice) {
                case 1:
                    booksMenu();
                    break;
                case 2:
                    ticketsMenu();
                    break;
                case 3:
                    magazinesMenu(); // Call magazines menu
                    break;
                case 4:
                    running = false;
                    System.out.println("Bye..");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void booksMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n-------------------------Books---------------------------------");
            viewItems();
            System.out.println("--------------------------------------------------------------");
            System.out.println("3. Add a Book");
            System.out.println("4. Edit a Book");
            System.out.println("5. Delete a Book");
            System.out.println("6. Sell a Book");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");
            int bookChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (bookChoice) {
                case 3:
                    addBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    sellBook();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private void magazinesMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n-------------------------Magazines---------------------------------");
            viewItems(); // Show all items, including magazines
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Add a Magazine");
            System.out.println("2. Edit a Magazine");
            System.out.println("3. Delete a Magazine");
            System.out.println("4. Sell a Magazine");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int magChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (magChoice) {
                case 1:
                    addMagazine();
                    break;
                case 2:
                    editMagazine();
                    break;
                case 3:
                    deleteMagazine();
                    break;
                case 4:
                    sellMagazine();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void ticketsMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n-------------------------Tickets---------------------------------");
            System.out.println("1. Sell a Ticket");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int ticketChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (ticketChoice) {
                case 1:
                    sellTicket();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void editBook() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the book to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToEdit = saleableItems.get(index - 1);
        editItem(itemToEdit);
        System.out.println("Book edited successfully.");
    }

    private void deleteBook() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the book to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToDelete = saleableItems.get(index - 1);
        removeItem(itemToDelete);
        System.out.println("Book deleted successfully.");
    }

    private void sellBook() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the book to sell: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToSell = saleableItems.get(index - 1);
        sellItem(itemToSell);
        System.out.println("Book sold successfully.");
    }
    private void addMagazine() {
        System.out.print("Enter Title ('q' to quit): ");
        String title = scanner.nextLine();
        if (title.equalsIgnoreCase("q")) return;

        System.out.print("Quantity to Order: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("ISBN13: ");
        String isbn13 = scanner.nextLine(); // Capture ISBN13 input

        // Create a new Magazine and add it to the store
        SaleableItem magazine = new Magazine(title, price, quantity, isbn13) {
            @Override
            public Double getBrand() {
                return 0.0;
            }
        }; // Assuming Magazine implements SaleableItem
        addItem(magazine);
        System.out.println("Magazine added successfully.");
    }

    private void editMagazine() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the magazine to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToEdit = saleableItems.get(index - 1);
        editItem(itemToEdit);
        System.out.println("Magazine edited successfully.");
    }

    private void deleteMagazine() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the magazine to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToDelete = saleableItems.get(index - 1);
        removeItem(itemToDelete);
        System.out.println("Magazine deleted successfully.");
    }

    private void sellMagazine() {
        viewItems(); // Show items to choose from
        System.out.print("Enter the index of the magazine to sell: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > saleableItems.size()) {
            System.out.println("Invalid index.");
            return;
        }

        SaleableItem itemToSell = saleableItems.get(index - 1);
        sellItem(itemToSell);
        System.out.println("Magazine sold successfully.");
    }

    private void sellTicket() {
        // Implement logic for selling a ticket here
        System.out.println("Ticket sold successfully."); // Placeholder
    }
}