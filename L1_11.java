import java.util.Scanner;

public class L1_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum = 0F;

        while (true) {
            System.out.print("Enter a number: ");
            float number = scanner.nextFloat();
            
            if (number <= 0) {
                break;
            }
            
            sum += number;
        }

        System.out.println("The sum is: " + sum);
        scanner.close();
    }   
}
