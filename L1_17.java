import java.util.Scanner;

public class L1_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter your years of service: ");
        int yearsOfService = scanner.nextInt();
        
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus is: " + bonus);
        } else {
            System.out.println("You are entitled to no bonus until next"+ (5 - yearsOfService) + " years.");
        }
        scanner.close();   
    }
}
