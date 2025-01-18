import java.util.Scanner;
public class HelloWorld {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int limit = inp.nextInt();

        System.out.println("Even numbers:");
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Odd numbers:");
        for (int i = 1; i <= limit; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        inp.close();
    }
}
