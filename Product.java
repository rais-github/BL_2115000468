public class Product {
    private final int productID;
    private static int discount;
    private int price;
    private String productName;
    private int quantity;

    public Product(int price, String productName, int quantity, int productID, int discount) {
        this.price = price;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        Product.discount = discount;
    }
    

    protected int getId() {
        return productID;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private static void updateDiscount(int newDiscount) {
        discount = newDiscount;
    }

    public void processDetails(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            System.out.println("Product ID: " + product.productID);
            System.out.println("Product Name: " + product.productName);
            System.out.println("Product Price: " + product.price);
            System.out.println("Product Quantity: " + product.quantity);
            System.out.println("Product Discount: " + discount);
        } else {
            System.out.println("Invalid object type");
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(100, "Product1", 10, 1, 5);
        Product.updateDiscount(15);
        Product product2 = new Product(200, "Product2", 20, 2, Product.discount);

        product1.processDetails(product1);
        product2.processDetails(product2);
        
        // Update discount

        
        
        // Process details again to see the updated discount
        product1.processDetails(product1);
        product2.processDetails(product2);
    }
}