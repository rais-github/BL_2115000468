import java.util.Scanner;

public class L1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        String result = (number >= 0) 
            ? "The sum of " + number + " natural numbers is " + (number * (number + 1) / 2)
            : "The number " + number + " is not a natural number";

        System.out.println(result);
        scanner.close();
    }
}
