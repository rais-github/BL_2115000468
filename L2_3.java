import java.util.Scanner;

public class L2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int phy = scanner.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemis = scanner.nextInt();

        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();

        int totalMarks = phy + chemis + maths;
        double percentage = (totalMarks / 3.0);
        double average = totalMarks / 3.0;

        char grade;
        if (percentage >= 80) {
            grade = 'A';
        } else if (percentage >= 70) {
            grade = 'B';
        } else if (percentage >= 60) {
            grade = 'C';
        } else if (percentage >= 50) {
            grade = 'D';
        } else if (percentage >= 40) {
            grade = 'E';
        } else {
            grade = 'R';
        }

        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
    
}
