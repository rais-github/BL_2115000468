
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String name;
    private String skills;

    public JobRole(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return skills;
    }

    public abstract boolean isQualified();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, String skills) {
        super(name, skills);
    }

    @Override
    public boolean isQualified() {
        return getSkills().contains("Java") || getSkills().contains("C++");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, String skills) {
        super(name, skills);
    }

    @Override
    public boolean isQualified() {
        return getSkills().contains("Python") || getSkills().contains("R");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, String skills) {
        super(name, skills);
    }

    @Override
    public boolean isQualified() {
        return getSkills().contains("Management") || getSkills().contains("Agile");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public boolean processResume() {
        return jobRole.isQualified();
    }
}

class ScreeningPipeline {
    public void processResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            Resume<? extends JobRole> resume = new Resume<>(jobRole);
            if (resume.processResume()) {
                System.out.println(jobRole.getName() + " is qualified for the role.");
            } else {
                System.out.println(jobRole.getName() + " is not qualified for the role.");
            }
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer("Alice", "Java, C++"));
        jobRoles.add(new DataScientist("Bob", "Python, R"));
        jobRoles.add(new ProductManager("Charlie", "Management, Agile"));

        ScreeningPipeline pipeline = new ScreeningPipeline();
        pipeline.processResumes(jobRoles);
    }
}