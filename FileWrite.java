import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWrite {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new FileWriter("output.txt", true); 

            String input;
            System.out.println("Enter text (type 'exit' to quit):");

            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Input has been written to output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}