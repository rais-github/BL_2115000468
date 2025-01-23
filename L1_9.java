import java.util.Scanner;

public class L1_9 {
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows: ");
    int rows = scanner.nextInt();
    System.out.print("Enter the number of columns: ");
    int columns = scanner.nextInt();

    
    int[][] matrix = new int[rows][columns];

    System.out.println("Enter the elements of the matrix:");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            matrix[i][j] = scanner.nextInt();
        }
    }

    // Create a 1D array to copy the elements of the 2D array
    int[] array = new int[rows * columns];
    int index = 0;

    // Copy the elements of the 2D array into the 1D array
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            array[index++] = matrix[i][j];
        }
    }

    System.out.println("The elements of the 1D array are:");
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    scanner.close();
 }   
}
