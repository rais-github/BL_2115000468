import java.util.Scanner;
public class L3_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        System.out.println("Is " + number + " a prime number? " + NumberChecker.isPrime(number));
        System.out.println("Is " + number + " a neon number? " + NumberChecker.isNeon(number));
        System.out.println("Is " + number + " a spy number? " + NumberChecker.isSpy(number));
        System.out.println("Is " + number + " an automorphic number? " + NumberChecker.isAutomorphic(number));
        System.out.println("Is " + number + " a buzz number? " + NumberChecker.isBuzz(number));
    }
}

class NumberChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    public static boolean isSpy(int number) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            number /= 10;
        }
        return sumOfDigits == productOfDigits;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        
        while (number > 0) {
            if (number % 10 != square % 10) {
                return false;
            }
            number /= 10;
            square /= 10;
        }
        return true;
        
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}