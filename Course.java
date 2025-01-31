public class Course {
    private String courseName;
    private int duration;
    private double fee;

    private static String instituteName;

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Duration: " + this.duration + " months");
        System.out.println("Fee: $" + this.fee);
        System.out.println("Institute Name: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("Tech Institute");

        Course course1 = new Course("Java Programming", 6, 500);
        Course course2 = new Course("Web Development", 4, 400);

        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}