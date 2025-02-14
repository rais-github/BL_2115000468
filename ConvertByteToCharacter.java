import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConvertByteToCharacter {
    public static void main(String[] args) {
        String fileName = "./file.txt";
        String charsetName = "UTF-8"; 

        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, charsetName)) {

            int data;
            while ((data = isr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}