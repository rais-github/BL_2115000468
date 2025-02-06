class Course {
    private String courseName;
    private int duration; 

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + ", Duration: " + duration + " hours";
    }
}

 class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isRecorded() {
        return isRecorded;
    }

    public void setRecorded(boolean isRecorded) {
        this.isRecorded = isRecorded;
    }

    @Override
    public String toString() {
        return super.toString() + ", Platform: " + platform + ", Recorded: " + isRecorded;
    }
}

 class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fee: $" + fee + ", Discount: " + discount + "%";
    }
}

public class EducationalCourse {
    public static void main(String[] args) {
        Course course = new Course("Java Programming", 40);
        Course onlineCourse = new OnlineCourse("Python Programming", 30, "Udemy", true);
        Course paidOnlineCourse = new PaidOnlineCourse("Data Science", 50, "Coursera", true, 200.0, 10.0);

        System.out.println(course);
        System.out.println(onlineCourse);
        System.out.println(paidOnlineCourse);
    }
}