import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadEfficiently {
    public static void main(String[] args) {
        String path = "annual-enterprise-survey-2023-financial-year-provisional.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            int batchSize = 100;

            while ((line = br.readLine()) != null) {
                count++;
                if (count % batchSize == 0) {
                    System.out.println("Processed " + count + " records.");
                }
            }
            
            if (count % batchSize != 0) {
                System.out.println("Processed " + count + " records.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
