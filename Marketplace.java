enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY
}

enum ClothingCategory {
    MEN, WOMEN, KIDS
}

enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}


public class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Great Gatsby", 20.0, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("Men's Shirt", 35.0, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, GadgetCategory.MOBILE);

        System.out.println("Before discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        applyDiscount(book, 10);
        applyDiscount(shirt, 15);
        applyDiscount(phone, 20);

        System.out.println("\nAfter discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}