public class SortingAnalysis {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90,4,8,5,5,5,5,5,2,5,5,5,2,56,2,4,2,2,7,8,9,5,5,5,5,5,5,2,5,4,7,8,5,2,2,8,5,5,5,4,7,8,5,0,82,5,2545,46,5,85558,7,9,2,20,45,7,8,2,0,0,32,6,6,8,4,7,5,6,23,8,8,5,5,5,5,555,555,5,8,85,2,2,836,1,0,1,0,1,0,1,2,6,68};

        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);
        System.out.println("Sorted array with Bubble Sort:");
        printArray(arr);

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("Sorted array with Merge Sort:");
        printArray(arr2);

        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println("Sorted array with Quick Sort:");
        printArray(arr3);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}