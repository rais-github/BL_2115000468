import java.util.Scanner;

public class L2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int power =  scanner.nextInt();

        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(number + " to the power of " + power + " is " + result);
        scanner.close();
    }
    
}
