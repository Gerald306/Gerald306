import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = getIntegerInput();
            switch (choice) {
                case 1: addBook(); break;
                case 2: borrowBook(); break;
                case 3: returnBook(); break;
                case 4: System.out.println("Exiting the library system. Goodbye!"); return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = getIntegerInput();

        library.putIfAbsent(title, new Book(title, author, 0));
        library.get(title).quantity += quantity;
        System.out.println("Book added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = getIntegerInput();

        if (library.containsKey(title) && library.get(title).quantity >= quantity) {
            library.get(title).quantity -= quantity;
            System.out.println("Successfully borrowed " + quantity + " copy(ies) of '" + title + "'.");
        } else {
            System.out.println("Insufficient stock or book not found.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = getIntegerInput();

        if (library.containsKey(title)) {
            library.get(title).quantity += quantity;
            System.out.println("Successfully returned " + quantity + " copy(ies) of '" + title + "'.");
        } else {
            System.out.println("This book does not belong to the library.");
        }
    }

    private static int getIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }
}
