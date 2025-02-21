import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class ReadWriteText{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file to read: ");
        String path = scanner.nextLine();
        
        if(!new File(path).exists()){
            System.out.println("File does not exist");
            scanner.close();
            return;
        }
        try(FileInputStream fis = new FileInputStream(path.toString())){
            FileOutputStream fos = new FileOutputStream("output.txt");
            int byteData ;
            while((byteData=fis.read())!=-1){
                fos.write(byteData);
            }
            fos.close();
            System.out.println("File copied successfully");
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        scanner.close();
    }
}