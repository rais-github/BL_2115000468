public class BookSystem {
    public String ISBN;
    protected String title;
    private String author;

    public BookSystem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends BookSystem {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN); 
        System.out.println("Title: " + title); 
        // System.out.println("Author: " + author); // Cannot access private member directly
    }
}

class Main {
    public static void main(String[] args) {
        BookSystem book = new BookSystem("123-456-789", "Java Programming", "John Doe");
        System.out.println("Author: " + book.getAuthor());
        book.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book.getAuthor());

        EBook ebook = new EBook("987-654-321", "Advanced Java", "Alice Smith");
        ebook.displayBookDetails();
    }
}