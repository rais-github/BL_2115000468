import java.util.Scanner;

public class L1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double [] heights = new double[11];
        double heightSum = 0d;
        for(int i = 0 ; i < 11 ; i++){
            heights[i]=scanner.nextDouble();
        }
        for(int i = 0 ; i < 11 ; i++)
        {
            heightSum+=heights[i];
        }

        System.out.println("The mean of the 11 players is: "+heightSum/11d);
        scanner.close();
    }
}
