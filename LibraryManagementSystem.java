abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrower;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 21; 
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved) {
            this.borrower = borrower;
            this.isReserved = true;
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrower;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 7; 
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved) {
            this.borrower = borrower;
            this.isReserved = true;
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrower;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 14; 
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved) {
            this.borrower = borrower;
            this.isReserved = true;
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        LibraryItem magazine = new Magazine("M001", "National Geographic", "Various Authors");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");

        System.out.println(book.getItemDetails());
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");

        System.out.println(magazine.getItemDetails());
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");

        System.out.println(dvd.getItemDetails());
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");

        Reservable reservableBook = (Reservable) book;
        reservableBook.reserveItem("John Doe");
        System.out.println("Book available: " + reservableBook.checkAvailability());
    }
}