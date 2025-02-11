public class TextEditor {
    private static final int MAX_HISTORY_SIZE = 10;
    private Node head;
    private Node tail;
    private Node current;
    private int size;

    private class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
            this.next = null;
            this.prev = null;
        }
    }

    public TextEditor() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public void addTextState(String text) {
        Node newNode = new Node(text);
        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            head = newNode;
        }
        current = newNode;
        tail = newNode;
        size++;
        if (size > MAX_HISTORY_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No state available.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addTextState("State 1");
        editor.addTextState("State 2");
        editor.addTextState("State 3");
        editor.displayCurrentState(); // Should display "State 3"
        editor.undo();
        editor.displayCurrentState(); // Should display "State 2"
        editor.redo();
        editor.displayCurrentState(); // Should display "State 3"
        editor.undo();
        editor.undo();
        editor.displayCurrentState(); // Should display "State 1"
    }
}