import java.util.Scanner;

public class L3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int digitSum=0;
        while(number != 0) {
            int digit = number % 10;
            digitSum += digit;
            number /= 10;
        }

        if(originalNumber % digitSum == 0) {
            System.out.println(originalNumber + " is Harshad number.");
        } else {
            System.out.println(originalNumber + " is not Harshad number.");
        }
        scanner.close();
    }
}
