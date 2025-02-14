import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurence {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java CountOccurrence <file-path> <word>");
            return;
        }

        String filePath = args[0];
        String targetWord = args[1];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}