import java.util.Scanner;

public class removeSpecificCharacter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scanner.nextLine();
        System.out.println("Enter the character to remove: ");
        char ch = scanner.next().charAt(0);

        String newStr = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ch){
                newStr += str.charAt(i);
            }
        }
        System.out.println("New string after removing '"+ch+"' is: "+newStr);
        scanner.close();
    }
}