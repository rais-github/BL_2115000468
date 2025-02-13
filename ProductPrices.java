public class ProductPrices {

    public static void main(String[] args) {
        double[] prices = {199.99, 49.99, 299.99, 149.99, 99.99};
        quickSort(prices, 0, prices.length - 1);
        
        System.out.println("Sorted product prices in ascending order:");
        for (double price : prices) {
            System.out.println(price);
        }
    }

    public static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}