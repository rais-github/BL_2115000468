import java.util.Scanner;

public class Book{
    private String title;
    private String author;
    private float price;

    public Book(){
        title = "";
        author = "";
        price = 0.0f;
    }

    public Book(String title, String author, float price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public float getPrice(){
        return price;
    }

    public void aboutBook(){
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Price: " + this.getPrice());
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        System.out.println("Enter the title of the book: ");
        book1.setTitle(new Scanner(System.in).nextLine());
        System.out.println("Enter the author of the book: ");
        book1.setAuthor(new Scanner(System.in).nextLine());  
        System.out.println("Enter the price of the book: ");
        book1.setPrice(new Scanner(System.in).nextFloat());

        book1.aboutBook();
    }

    

}