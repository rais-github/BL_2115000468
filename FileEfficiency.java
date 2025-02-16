import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class FileEfficiency {
    public static void main(String[] args) {
        String filePath = "./file.txt";
        
        
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long fileReaderTime = System.currentTimeMillis() - startTime;
        
        
        startTime = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long inputStreamReaderTime = System.currentTimeMillis() - startTime;
        
        // Print results
        System.out.println("FileReader Time: " + fileReaderTime + "ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + "ms");
    }
}