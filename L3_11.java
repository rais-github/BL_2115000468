import java.util.Random;

public class L3_11 {
    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData(10);
        int[][] updatedEmployeeData = calculateNewSalaryAndBonus(employeeData);
        displaySummary(employeeData, updatedEmployeeData);
    }

    public static int[][] generateEmployeeData(int numberOfEmployees) {
        Random random = new Random();
        int[][] data = new int[numberOfEmployees][2];
        for (int i = 0; i < numberOfEmployees; i++) {
            data[i][0] = 10000 + random.nextInt(90000); 
            data[i][1] = random.nextInt(11); 
        }
        return data;
    }

    public static int[][] calculateNewSalaryAndBonus(int[][] employeeData) {
        int[][] updatedData = new int[employeeData.length][2];
        for (int i = 0; i < employeeData.length; i++) {
            int salary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            double bonusPercentage = yearsOfService > 5 ? 0.05 : 0.02;
            int bonus = (int) (salary * bonusPercentage);
            int newSalary = salary + bonus;
            updatedData[i][0] = newSalary;
            updatedData[i][1] = bonus;
        }
        return updatedData;
    }

    public static void displaySummary(int[][] oldData, int[][] newData) {
        int totalOldSalary = 0;
        int totalNewSalary = 0;
        int totalBonus = 0;

        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Emp No.", "Old Salary", "Years", "New Salary", "Bonus");
        for (int i = 0; i < oldData.length; i++) {
            int oldSalary = oldData[i][0];
            int yearsOfService = oldData[i][1];
            int newSalary = newData[i][0];
            int bonus = newData[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-10d %-10d %-10d %-10d %-10d\n", i + 1, oldSalary, yearsOfService, newSalary, bonus);
        }

        System.out.println("\nSummary:");
        System.out.printf("Total Old Salary: %d\n", totalOldSalary);
        System.out.printf("Total New Salary: %d\n", totalNewSalary);
        System.out.printf("Total Bonus: %d\n", totalBonus);
    }
}