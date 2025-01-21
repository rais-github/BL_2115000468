public class L1_12 {
    public static void main(String[] args) {
        
    
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    System.out.print("Enter the base of the triangle in inches: ");
    double baseInInches = scanner.nextDouble();

    System.out.print("Enter the height of the triangle in inches: ");
    double heightInInches = scanner.nextDouble();

    double areaInSquareInches = 0.5 * baseInInches * heightInInches;
    double areaInSquareCentimeters = areaInSquareInches * 6.4516;

    double heightInCm = heightInInches * 2.54;
    double heightInFeet = heightInInches / 12;

    System.out.println("Area of the triangle in square inches: " + areaInSquareInches);
    System.out.println("Area of the triangle in square centimeters: " + areaInSquareCentimeters);
    System.out.println("Height in cm is " + heightInCm + " while in feet is " + heightInFeet + " and inches is " + heightInInches);

    scanner.close();
}
}