import java.util.Date;

public class TaskScheduler {

    private int size = 0;

    class SchedulerNode {
        private int taskId;
        private String taskName;
        private int priority;
        private Date dueDate;
        private SchedulerNode next;

        public SchedulerNode(int taskId, String taskName, int priority, Date dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private SchedulerNode head;

    public TaskScheduler() {
        this.head = null;
    }

    private void addAtBeginning(int taskId, String taskName, int priority, Date dueDate) {
        SchedulerNode newNode = new SchedulerNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            SchedulerNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        size++;
    }

    private void addAtEnd(int taskId, String taskName, int priority, Date dueDate) {
        SchedulerNode newNode = new SchedulerNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            SchedulerNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    private void addAtPosition(int taskId, String taskName, int priority, Date dueDate, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        SchedulerNode newNode = new SchedulerNode(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
        } else if (position == size) {
            addAtEnd(taskId, taskName, priority, dueDate);
        } else {
            SchedulerNode temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
   
    private void removeById(int taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        SchedulerNode temp = head;
        SchedulerNode prev = null;
        while (temp.taskId != taskId) {
            if (temp.next == head) {
                System.out.println("Task not found");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == head && temp.next == head) {
            head = null;
            size--;
            return;
        }
        if (temp == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = temp.next;
            prev.next = head;
        } else if (temp.next == head) {
            prev.next = head;
        } else {
            prev.next = temp.next;
        }
        size--;
    }

    private void displaySchedules(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        SchedulerNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    private void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        SchedulerNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }
    public static void main(String[] args) {
        // Test the circular singly linked list implementation
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtBeginning(1, "Task 1", 1, new Date());
        scheduler.addAtEnd(2, "Task 2", 2, new Date());
        scheduler.addAtEnd(3, "Task 3", 3, new Date());
        scheduler.addAtEnd(4, "Task 4", 4, new Date());

        scheduler.displaySchedules();
        System.out.println();System.out.println();System.out.println();System.out.println();
        scheduler.removeById(1);
        System.out.println();System.out.println();System.out.println();System.out.println();
        scheduler.displaySchedules();
        System.out.println();System.out.println();System.out.println();System.out.println();
        scheduler.searchByPriority(3);
    
    }
}
