import java.util.Scanner;
public class L1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number ");
        int num = scanner.nextInt();
        System.out.println();
        for(int i = 1 ; i <= 10 ; i++)
        {
            System.out.println(num+" * "+i+" = "+num*i);
        }
        scanner.close();
    }
}
