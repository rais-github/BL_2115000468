public class CircularBufferSimulation {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size == capacity) {
            head = (head + 1) % capacity; 
        } else {
            size++;
        }
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("Buffer is empty");
        }
        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularBufferSimulation buffer = new CircularBufferSimulation(5);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4);
        buffer.add(5);
        System.out.println(buffer.remove()); // 1
        buffer.add(6);
        System.out.println(buffer.remove()); // 2
        buffer.add(7);
        while (!buffer.isEmpty()) {
            System.out.println(buffer.remove());
        }
    }
}