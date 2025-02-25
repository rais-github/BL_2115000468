import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountRowsInCSV {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))){
            String line;
            int rowsCount=-1;
            while((line=br.readLine())!=null){
                rowsCount=rowsCount+1;
                String[] values = line.split(",");
                System.out.println("ID: "+values[0]+" Name: "+values[1]+" Age: "+values[2]+" Marks: "+values[3]);  
            }
            System.out.println("Total number of rows in CSV file: "+rowsCount);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
