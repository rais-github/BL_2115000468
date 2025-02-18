abstract class CourseType {
    private String courseName;
    private String courseCode;

    public CourseType(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through exams for course: " + getCourseName());
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through assignments for course: " + getCourseName());
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through research for course: " + getCourseName());
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void evaluateCourse() {
        courseType.evaluate();
    }
}

public class universityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>(new ExamCourse("Mathematics", "MATH101"));
        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse("History", "HIST201"));
        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse("Physics", "PHYS301"));

        examCourse.evaluateCourse();
        assignmentCourse.evaluateCourse();
        researchCourse.evaluateCourse();
    }
}