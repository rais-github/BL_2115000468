public class Propagation {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
    }
    private static void method1() throws ArithmeticException {
        int a = 10;
        int b = 0;
        int c = a/b;
        System.out.println(c);
    }
    private static void method2() {
       method1();
    }
}
