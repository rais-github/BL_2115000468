import java.util.Scanner;

public class toggleString{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String resultant = new String();
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                resultant += Character.toLowerCase(c);
            }else{
                resultant += Character.toUpperCase(c);
            }
        }
        System.out.println(resultant);
        scanner.close();
    }
}