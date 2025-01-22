import java.util.Scanner;

public class L2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        short year = scanner.nextShort();
        if (year >= 1582) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
            } else {
            System.out.println(year + " is not a leap year.");
            }
        } else {
            System.out.println("Year must be greater than or equal to 1582.");
        }
        scanner.close();
    }
    
}
