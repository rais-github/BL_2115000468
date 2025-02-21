import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class UpperToLower {
    public static void main(String[] args) {
        String path = "./sample.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ){
            String line;
            while((line = br.readLine()) != null){
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("File copied successfully with buffering.");

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
       