import java.util.Scanner;
public class L2_11{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // quadratic equation: ax^2 + bx + c = 0
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();

        double delta = Math.pow(b, 2) - 4 * a * c;
        double[] roots = findRoots(a, b, c, delta);
        if (roots.length == 0) {
            System.out.println("The equation has no real roots.");
        } else if (roots.length == 1) {
            System.out.println("The equation has one root: " + roots[0]);
        } else {
            System.out.println("The equation has two roots: " + roots[0] + " and " + roots[1]);
        }

        scanner.close();
    }
    private static double[] findRoots(int a , int b , int c , double delta){
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{};
        }
    }
}