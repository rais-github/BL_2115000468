import java.util.Scanner;
public class A17_Addition {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n1 = inp.nextInt();
        int n2 = inp.nextInt();
        int n3 = inp.nextInt();
        System.out.println("Sum is: " + n1+n2+n3);
        inp.close();
    }
}
