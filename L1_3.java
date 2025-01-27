import java.util.Scanner;

public class L1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        int numberOfHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        System.out.println("The maximum number of possible handshakes is: " + numberOfHandshakes);
        
        scanner.close();
    }
}