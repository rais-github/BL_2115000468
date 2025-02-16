public class FibonnaciComparison {
    

public static void main(String[] args) {
    int n = 30; 
    // Iterative Fibonacci
    long startTimeIterative = System.nanoTime();
    int iterativeResult = iterativeFibonacci(n);
    long endTimeIterative = System.nanoTime();
    long durationIterative = endTimeIterative - startTimeIterative;

    // Recursive Fibonacci
    long startTimeRecursive = System.nanoTime();
    int recursiveResult = recursiveFibonacci(n);
    long endTimeRecursive = System.nanoTime();
    long durationRecursive = endTimeRecursive - startTimeRecursive;

    System.out.println("Iterative Fibonacci result: " + iterativeResult + ", Time taken: " + durationIterative + " nanoseconds");
    System.out.println("Recursive Fibonacci result: " + recursiveResult + ", Time taken: " + durationRecursive + " nanoseconds");
}

public static int iterativeFibonacci(int n) {
    if (n <= 1) return n;
    int fib = 1;
    int prevFib = 1;

    for (int i = 2; i < n; i++) {
        int temp = fib;
        fib += prevFib;
        prevFib = temp;
    }
    return fib;
}

public static int recursiveFibonacci(int n) {
    if (n <= 1) return n;
    return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
}}