import java.util.Scanner;

public class L1_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child gets " + result[1] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[0]);
        scanner.close();
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number % divisor; // Remainder
        result[1] = number / divisor; // Quotient
        return result;
    }
}