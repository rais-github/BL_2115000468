import java.util.Scanner;

public class L1_3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int firstNum = inp.nextInt();
        int secondNum = inp.nextInt();
        int thirdNum = inp.nextInt();

        int largest;

        if (firstNum >= secondNum && firstNum >= thirdNum) {
            largest = firstNum;
        } else if (secondNum >= firstNum && secondNum >= thirdNum) {
            largest = secondNum;
        } else {
            largest = thirdNum;
        }

        System.out.println("The largest number is: " + largest);

        inp.close();
    }
}
