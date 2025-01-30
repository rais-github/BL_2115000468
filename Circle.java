import java.util.Scanner;
public class Circle{
    private final double PI = 3.14159;
    private double radius;
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return PI * radius * radius;
    }
    public double getCircumference(){
        return 2 * PI * radius;
    }
    public Circle(){
        radius = 0.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public static void main(String[] args){
        Circle circle = new Circle();
        circle.setRadius(getInput(new Scanner(System.in), "Enter the radius of the circle: "));
        System.out.println("The area of the circle is " + circle.getArea());
        System.out.println("The circumference of the circle is " + circle.getCircumference());
    }
    private static  double getInput(Scanner input, String prompt){
        System.out.print(prompt);
        return input.nextDouble();
    }
}