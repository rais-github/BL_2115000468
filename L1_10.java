import java.util.Scanner;

public class L1_10 {
    public static void main(String[] args) {
        double total = 0.0D;
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        while (number != 0) {
            System.out.print("Enter a number (0 to quit): ");
            number = scanner.nextDouble();
            if (number != 0) {
                total += number;
            }
        } 

        scanner.close();
        System.out.println("The total sum is: " + total);
    }
}
