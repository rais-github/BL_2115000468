import java.util.Scanner;
public class L1_2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int firstNum = inp.nextInt();
        int secondNum = inp.nextInt();
        int thirdNum = inp.nextInt();

        if (firstNum < secondNum && firstNum < thirdNum) {
            System.out.println("firstNum is the smallest");
        } else {
            System.out.println("firstNum is not the smallest");
        }
        inp.close()
;    }
}
