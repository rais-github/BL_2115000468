import java.util.Stack;

public class implementQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public implementQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int data) {
        this.stack1.push(data);
    }

    public int dequeue() {
        if (this.stack2.isEmpty()) {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(stack1.pop());
            }
        }
        if (this.stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return this.stack2.pop();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public static void main(String[] args) {
        implementQueue queue = new implementQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 4
    }
}