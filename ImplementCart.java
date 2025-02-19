import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ImplementCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cartItems;
    private TreeMap<Double, String> sortedItems;

    public ImplementCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        sortedItems = new TreeMap<>();
    }

    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    public void addItemToCart(String productName, int quantity) {
        if (productPrices.containsKey(productName)) {
            cartItems.put(productName, quantity);
            sortedItems.put(productPrices.get(productName), productName);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayCartItems() {
        System.out.println("Items in cart:");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
        }
    }

    public void displaySortedItems() {
        System.out.println("Items sorted by price:");
        for (Map.Entry<Double, String> entry : sortedItems.entrySet()) {
            System.out.println(entry.getValue() + " - Price: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ImplementCart cart = new ImplementCart();
        cart.addProduct("Apple", 1.0);
        cart.addProduct("Banana", 0.5);
        cart.addProduct("Orange", 0.75);

        cart.addItemToCart("Apple", 2);
        cart.addItemToCart("Banana", 5);
        cart.addItemToCart("Orange", 3);

        cart.displayCartItems();
        cart.displaySortedItems();
    }
}