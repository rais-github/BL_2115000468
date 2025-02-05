import java.util.ArrayList;
import java.util.List;


class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.setProfessor(this);
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class Course {
    private String title;
    private Professor professor;
    private List<Student> students;

    public Course(String title) {
        this.title = title;
        this.students = new ArrayList<>();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getTitle() {
        return title;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Professor professor1 = new Professor("Dr. Smith");

        Course course1 = new Course("Computer Science 101");

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);

        professor1.assignCourse(course1);

        System.out.println("Course: " + course1.getTitle());
        System.out.println("Professor: " + course1.getProfessor().getName());
        System.out.println("Enrolled Students: ");
        for (Student student : course1.getStudents()) {
            System.out.println(student.getName());
        }
    }
}