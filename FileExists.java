import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileExists {
    public static void main(String[] args) {
        String path = "./data.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path));
        ){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        
        catch(IOException e){
            System.out.println("File does not exist");
            e.printStackTrace();
        }
    }
}
