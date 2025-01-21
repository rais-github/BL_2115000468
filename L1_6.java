public class L1_6 {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        double discount = fee * discountPercent / 100.0;
        double discountedPrice = fee - discount;

        System.out.println("Discounted Amount: " + discount);
        System.out.println("Discounted Price: " + discountedPrice);
    }
}
