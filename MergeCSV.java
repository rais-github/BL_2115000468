import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) {
        try (BufferedReader br1 = new BufferedReader(new FileReader("student1.csv"));
             BufferedReader br2 = new BufferedReader(new FileReader("student2.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("student.csv"))) {

            Map<String, String[]> studentMap = new HashMap<>();
            String line;

            while ((line = br1.readLine()) != null) {
                String[] student1 = line.split(",");
                if (!student1[0].equals("ID")) {
                    studentMap.put(student1[0], student1);
                } else {
                    bw.write(line + ",Marks,Grade\n");
                }
            }

            while ((line = br2.readLine()) != null) {
                String[] student2 = line.split(",");
                if (!student2[0].equals("ID")) {
                    String[] student1 = studentMap.get(student2[0]);
                    if (student1 != null) {
                        bw.write(String.join(",", student1) + "," + student2[1] + "," + student2[2] + "\n");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
