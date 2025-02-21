import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleInput {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        String name = System.console().readLine();
        System.out.println("Enter your age: ");
        int age = Integer.parseInt(System.console().readLine());
        System.out.println("Favorite programming language: ");
        String language = System.console().readLine();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Age: " + age);
            bw.newLine();
            bw.write("Favorite programming language: " + language);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
