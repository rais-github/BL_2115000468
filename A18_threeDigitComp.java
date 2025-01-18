import java.util.Scanner;

public class A18_threeDigitComp {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[5];

    System.out.println("Enter 5 three-digit numbers:");
    for (int i = 0; i < 5; i++) {
        while (true) {
            int num = scanner.nextInt();
            if (num >= 100 && num <= 999) {
                numbers[i] = num;
                break;
            } else {
                System.out.println("Please enter a three-digit number:");
            }
        }
    }

    int max = numbers[0];
    int min = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
        if (numbers[i] < min) {
            min = numbers[i];
        }
    }

    System.out.println("Maximum number: " + max);
    System.out.println("Minimum number: " + min);
    scanner.close();
}
}
