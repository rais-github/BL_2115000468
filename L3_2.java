import java.util.Scanner;

public class L3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int count = 0;
        
        while (number != 0) {
            number /= 10;
            count++;
        }
        
        System.out.println("Number of digits: " + count);
        input.close();
    }
    
}
