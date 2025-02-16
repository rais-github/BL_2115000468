import java.util.Arrays;
import java.util.Random;

public class SearchAnalysis {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000, 78, 4, 5, 2, 6, 7, 8, 25, 48, 99, 41, 91864, 6891, 7891, 6817, 948, 81814, 1896, 486, 815418, 46891, 849, 46, 146, 481, 664, 11, 6438917, 1817, 86, 781478, 16481, 1684, 41641, 6118, 781, 3488, 80, 849, 89948046, 408, 4896, 7849, 448, 486, 468, 6408, 6480, 46, 450, 540, 4650, 5460, 6540, 68168, 6871, 678, 76817, 784, 1, 2, 5, 8, 9, 66, 3, 32, 51, 5101, 5445, 541718, 87, 41348, 864, 6487, 18778, 40840, 115, 150, 103035, 03447474, 41, 77, 85, 58, 52, 525, 669, 96, 3544, 6781, 52, 21};
        Random random = new Random();

        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }
            int target = data[random.nextInt(size)];

            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;

            // Binary Search
            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + " ms");
            System.out.println();
        }
    }

    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;
            }
            if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}