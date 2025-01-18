import java.util.Scanner;
public class A17_Compare3Nums {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n1 = inp.nextInt();
        int n2 = inp.nextInt();
        int n3 = inp.nextInt();
        
        if (n1 > n2 && n1 > n3) {
            System.out.println(n1 + " is the largest number.");
        } else if (n2 > n1 && n2 > n3) {
            System.out.println(n2 + " is the largest number.");
        } else {
            System.out.println(n3 + " is the largest number.");
        }
        inp.close();
    }
}
