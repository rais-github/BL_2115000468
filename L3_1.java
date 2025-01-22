import java.util.Scanner;

public class L3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int digitCOunt = 0;
        int sum = 0;
        int originalNumber = number;

        while(number != 0) {
            digitCOunt++;
            number /= 10;
        }

        number = originalNumber;
        while(number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digitCOunt);
            number /= 10;
        }

        if(sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        input.close();
    }
    
}
