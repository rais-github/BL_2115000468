import java.util.Scanner;
public class L3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        scanner.close();

        System.out.println("Count of digits: " + NumberChecker.countDigits(number));
        int[] digitsArray = NumberChecker.storeDigits(number);
        System.out.println("Digits array: " + java.util.Arrays.toString(digitsArray));
        System.out.println("Sum of digits: " + NumberChecker.sumOfDigits(digitsArray));
        System.out.println("Sum of squares of digits: " + NumberChecker.sumOfSquaresOfDigits(digitsArray));
        System.out.println("Is Harshad number: " + NumberChecker.isHarshadNumber(number));
        int[][] frequencyArray = NumberChecker.digitFrequency(number);
        System.out.println("Digit frequencies:");
        for (int[] freq : frequencyArray) {
            System.out.println("Digit: " + freq[0] + ", Frequency: " + freq[1]);
        }
    }
}

class NumberChecker {
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int number) {
        int[] digits = storeDigits(number);
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }
}