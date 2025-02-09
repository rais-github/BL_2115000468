abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private static final double ADDITIONAL_CHARGE = 50.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + ADDITIONAL_CHARGE) * getQuantity();
    }
}

interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class OrderProcessor {
    public void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: " + item.calculateTotalPrice());
    }
}

class Order implements Discountable {
    private FoodItem foodItem;
    private double discountPercentage;

    public Order(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: " + discountPercentage + "%";
    }

    public double getFinalPrice() {
        double totalPrice = foodItem.calculateTotalPrice();
        return totalPrice - (totalPrice * discountPercentage / 100);
    }

    public void printOrderDetails() {
        System.out.println(foodItem.getItemDetails());
        System.out.println(getDiscountDetails());
        System.out.println("Final Price: " + getFinalPrice());
    }
}

public class OnlineFoodSystem {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Paneer Tikka", 200, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Curry", 300, 1);

        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(vegItem);
        processor.processOrder(nonVegItem);

        Order order = new Order(nonVegItem);
        order.applyDiscount(10);
        order.printOrderDetails();
    }
}