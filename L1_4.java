public class L1_4 {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercentage = (double) profit / costPrice * 100;

        System.out.printf("Cost Price: INR %d\nSelling Price: INR %d\nProfit: INR %d\nProfit Percentage: %.2f%%\n", costPrice, sellingPrice, profit, profitPercentage);
    }
}
