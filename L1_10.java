import java.util.Scanner;

public class L1_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        double heightCm = scanner.nextDouble();
        double heightInches = heightCm / 2.54;
        int feet = (int) (heightInches / 12);
        double inches = heightInches % 12;
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", heightCm, feet, inches);
        scanner.close();
    }
}
