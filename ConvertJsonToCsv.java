import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


        public class ConvertJsonToCsv {
            public static void main(String[] args) {
                String jsonFilePath = "students.json";
                String csvFilePath = "students.csv";
                
                try {
                    List<Student> students = readJson(jsonFilePath);
                    writeCsv(students, csvFilePath);
                    List<Student> studentsFromCsv = readCsv(csvFilePath);
                    writeJson(studentsFromCsv, "students_from_csv.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private static List<Student> readJson(String filePath) throws IOException {
                Gson gson = new Gson();
                FileReader reader = new FileReader(filePath);
                List<Student> students = gson.fromJson(reader, new TypeToken<List<Student>>(){}.getType());
                reader.close();
                return students;
            }

            private static void writeCsv(List<Student> students, String filePath) throws IOException {
                CSVWriter writer = new CSVWriter(new FileWriter(filePath));
                writer.writeNext(new String[]{"Name", "Age", "Grade"});
                for (Student student : students) {
                    writer.writeNext(new String[]{student.getName(), String.valueOf(student.getAge()), student.getGrade()});
                }
                writer.close();
            }

            private static List<Student> readCsv(String filePath) throws IOException {
                CSVReader reader = new CSVReader(new FileReader(filePath));
                List<String[]> lines = reader.readAll();
                reader.close();
                List<Student> students = new ArrayList<>();
                for (int i = 1; i < lines.size(); i++) {
                    String[] line = lines.get(i);
                    students.add(new Student(line[0], Integer.parseInt(line[1]), line[2]));
                }
                return students;
            }

            private static void writeJson(List<Student> students, String filePath) throws IOException {
                Gson gson = new Gson();
                FileWriter writer = new FileWriter(filePath);
                gson.toJson(students, writer);
                writer.close();
            }
        }

        class Student {
            private String name;
            private int age;
            private String grade;

            public Student(String name, int age, String grade) {
                this.name = name;
                this.age = age;
                this.grade = grade;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public String getGrade() {
                return grade;
            }
        }
