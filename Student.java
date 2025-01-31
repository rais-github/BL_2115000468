public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public static void main(String[] args) {
        PostgraduateStudent student1 = new PostgraduateStudent();
        student1.rollNumber = 1;
        student1.name = "John Doe";
        student1.setCGPA(3.5);

        student1.displayStudentDetails();
    }
}

class PostgraduateStudent extends Student {
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}