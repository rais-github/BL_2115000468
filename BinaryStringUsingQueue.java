import java.util.LinkedList;
import java.util.Queue;

public class BinaryStringUsingQueue {
    public static void main(String[] args) {
        int N = 10; // Example value for N
        generateBinaryNumbers(N);
    }

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            System.out.println(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}