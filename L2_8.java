import java.util.Scanner;

public class L2_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] physicsMarks = new int[numStudents];
        int[] chemistryMarks = new int[numStudents];
        int[] mathsMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            
            System.out.print("Physics: ");
            physicsMarks[i] = scanner.nextInt();
            while (physicsMarks[i] < 0) {
                System.out.print("Invalid input. Enter positive value for Physics: ");
                physicsMarks[i] = scanner.nextInt();
            }
            
            System.out.print("Chemistry: ");
            chemistryMarks[i] = scanner.nextInt();
            while (chemistryMarks[i] < 0) {
                System.out.print("Invalid input. Enter positive value for Chemistry: ");
                chemistryMarks[i] = scanner.nextInt();
            }
            
            System.out.print("Maths: ");
            mathsMarks[i] = scanner.nextInt();
            while (mathsMarks[i] < 0) {
                System.out.print("Invalid input. Enter positive value for Maths: ");
                mathsMarks[i] = scanner.nextInt();
            }
            
            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 3.0;
            
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + physicsMarks[i]);
            System.out.println("Chemistry: " + chemistryMarks[i]);
            System.out.println("Maths: " + mathsMarks[i]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
        }

        scanner.close();
    }
}
