import java.util.Scanner;

public class L3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int divisorSum =0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisorSum += i;
            }
        }
        if(divisorSum > number) {
            System.out.println("The number is abundant.");
        } else {
            System.out.println("The number is not abundant.");
        }
        sc.close();
    }
}
