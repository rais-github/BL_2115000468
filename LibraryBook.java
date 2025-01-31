public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book: " + title + " is currently unavailable.");
        }
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
        System.out.println("Book Price: $" + book.getPrice());
        System.out.println("Is Book Available? " + book.isAvailable());

        book.borrowBook();
        System.out.println("Is Book Available? " + book.isAvailable());
    }
}