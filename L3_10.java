import java.util.Scanner;
public class L3_10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates of point A (x1 y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        
        System.out.println("Enter coordinates of point B (x2 y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        
        System.out.println("Enter coordinates of point C (x3 y3): ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        
        scanner.close();
        if (areCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using the slope method.");
        } else {
            System.out.println("The points are not collinear using the slope method.");
        }
        
        if (areCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using the area method.");
        } else {
            System.out.println("The points are not collinear using the area method.");
        }
        
        }
        
        public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int slopeAB = (y2 - y1) * (x3 - x2);
        int slopeBC = (y3 - y2) * (x2 - x1);
        return slopeAB == slopeBC;
        }
        
        public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
        
    }
}