import java.util.Scanner;

public class L2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ": ");
            while (true) {
            try {
                salaries[i] = Double.parseDouble(scanner.nextLine());
                if (salaries[i] <= 0) {
                throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid salary for employee " + (i + 1) + ": ");
            }
            }

            System.out.println("Enter years of service for employee " + (i + 1) + ": ");
            while (true) {
            try {
                yearsOfService[i] = Double.parseDouble(scanner.nextLine());
                if (yearsOfService[i] < 0) {
                throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid years of service for employee " + (i + 1) + ": ");
            }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
            bonuses[i] = salaries[i] * 0.05;
            } else {
            bonuses[i] = salaries[i] * 0.02;
            }
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        scanner.close();
    }
}
