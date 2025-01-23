import java.util.Scanner;

        public class L2_4 {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a number: ");
                String number = scanner.nextLine();
                int maxDigit = 10;
                int[] digits = new int[maxDigit];
                int index = 0;

                for (char ch : number.toCharArray()) {
                    if (index == maxDigit) {
                        maxDigit += 10;
                        int[] temp = new int[maxDigit];
                        System.arraycopy(digits, 0, temp, 0, digits.length);
                        digits = temp;
                    }
                    digits[index++] = Character.getNumericValue(ch);
                }

                int largest = Integer.MIN_VALUE;
                int secondLargest = Integer.MIN_VALUE;

                for (int i = 0; i < index; i++) {
                    if (digits[i] > largest) {
                        secondLargest = largest;
                        largest = digits[i];
                    } else if (digits[i] > secondLargest && digits[i] != largest) {
                        secondLargest = digits[i];
                    }
                }

                System.out.println("Largest digit: " + largest);
                System.out.println("Second largest digit: " + secondLargest);

                scanner.close();
    }
}
