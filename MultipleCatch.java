public class MultipleCatch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5}; 
        int index = 2; 

        try {
            System.out.println("Value at index " + index + ": " + getValueAtIndex(array, index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static int getValueAtIndex(int[] array, int index) {
        return array[index];
    }
}