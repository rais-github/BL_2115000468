public class SortBookPrices {

    public static void main(String[] args) {
        double[] prices = {29.99, 15.99, 49.99, 9.99, 19.99, 39.99};
        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Sorted book prices:");
        for (double price : prices) {
            System.out.println(price);
        }
    }

    public static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(double[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}