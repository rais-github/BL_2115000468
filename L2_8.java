import java.util.Scanner;
public class L2_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name=scanner.nextLine();
        String fromCity=scanner.nextLine();
        String viaCity=scanner.nextLine();
        String toCity=scanner.nextLine();

        int fromToVia = scanner.nextInt();
        int viaToFinal = scanner.nextInt();

        int timeTaken = scanner.nextInt();

        int fee = scanner.nextInt();
        int discountPrecent = scanner.nextInt();

        System.out.println("The results of Int Operations are ___,___and___.");
        scanner.close();
    }
}
