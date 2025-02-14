public class SearchNegative {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, -4, 5, -6};
        int index = findFirstNegative(array);
        System.out.println("Index of first negative number: " + index);
    }

    public static int findFirstNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}