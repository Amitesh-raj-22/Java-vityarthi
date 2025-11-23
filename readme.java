import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getIsIssued() { return isIssued; }

    public void issueBook() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void issueBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number!");
            return;
        }
        Book b = books.get(index - 1);
        if (!b.getIsIssued()) {
            b.issueBook();
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued!");
        }
    }

    public void returnBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number!");
            return;
        }
        Book b = books.get(index - 1);
        if (b.getIsIssued()) {
            b.returnBook();
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not issued!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice = 0;

        System.out.println("--- Welcome to Simple Library Management System ---");

        while (choice != 6) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    library.viewBooks();
                    System.out.print("Enter book number to issue: ");
                    int issueIndex = Integer.parseInt(sc.nextLine());
                    library.issueBook(issueIndex);
                    break;

                case 4:
                    library.viewBooks();
                    System.out.print("Enter book number to return: ");
                    int returnIndex = Integer.parseInt(sc.nextLine());
                    library.returnBook(returnIndex);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid option!");
            }
        }
        sc.close();
    }
}
