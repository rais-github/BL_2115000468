import java.util.Scanner;
public class L2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the natural number: ");
        int n = scanner.nextInt();
        if(recursiveSum(n)==formulaeSum(n)){
            System.out.println("The formulae and recursive sum are equal, correct Computations");
        }
        else{
            System.out.println("The formulae and recursive sum are not equal, incorrect Computations!");
        }
        scanner.close();
    }
    private static int formulaeSum(int n){
        return n*(n+1)/2;
    }
    private static int recursiveSum(int n){
        if(n==0){
            return 0;
        }
        else{
            return n+recursiveSum(n-1);
        }
    }
}
