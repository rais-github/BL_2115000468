import java.util.Scanner;

public class L2_2 {
    
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter value for a: ");
                int a = scanner.nextInt();

                System.out.print("Enter value for b: ");
                int b = scanner.nextInt();

                System.out.print("Enter value for c: ");
                int c = scanner.nextInt();

                int result1 = a + b * c;
                int result2 = a * b + c;
                int result3 = c + a / b;
                int result4 = a % b + c;

                System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
                
                scanner.close();
            }
        
}

