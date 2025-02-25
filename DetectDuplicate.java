import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DetectDuplicate {
    public static void main(String[] args) {
        String csvFile = "path/to/your/csvfile.csv";
        String line;
        String csvSplitBy = ",";
        Map<String, String> records = new HashMap<>();
        Map<String, String> duplicates = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSplitBy);
                String id = fields[0]; 
                if (records.containsKey(id)) {
                    duplicates.put(id, line);
                } else {
                    records.put(id, line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Duplicate Records:");
        for (String record : duplicates.values()) {
            System.out.println(record);
        }
    }
}