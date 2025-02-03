public class Student {
    private static String universityName = "Default University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    public void displayStudentInfo() {
        if (this instanceof Student) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        }
    }

    public static void setUniversityName(String universityName) {
        Student.universityName = universityName;
    }

    public static void main(String[] args) {
        Student.setUniversityName("BridgeLab University");
        Student student1 = new Student("Alice", 1, "A");
        Student student2 = new Student("Bob", 2, "B");

        student1.displayStudentInfo();
        student2.displayStudentInfo();

        student1.updateGrade("A+");
        student1.displayStudentInfo();

        Student.displayTotalStudents();
    }
}