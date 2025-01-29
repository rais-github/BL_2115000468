import java.util.Scanner;

public class removeDuplicates{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String resultantString = "";
        for(int i = 0; i < string.length(); i++){
            if(resultantString.indexOf(string.charAt(i)) == -1){
                resultantString += string.charAt(i);
            }
        }
        System.out.println(resultantString);
        scanner.close();
    }
}