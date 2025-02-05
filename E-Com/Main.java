import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<Product> products;
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe");
        Order order = new Order(customer);

        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);

        order.addProduct(product1);
        order.addProduct(product2);

        customer.placeOrder(order);

        System.out.println("Customer: " + customer.getName());
        for (Order o : customer.getOrders()) {
            System.out.println("Order for customer: " + o.getCustomer().getName());
            for (Product p : o.getProducts()) {
                System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice());
            }
        }
    }
}