import java.util.Scanner;

public class L2_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Multiples of " + number + " between 1 and 100 are: ");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.print(i+", ");
            }
        }

        scanner.close();
    }
}
