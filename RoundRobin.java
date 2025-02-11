import java.util.Scanner;

class Process {
    int processID;
    int burstTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobin {
    private Process head = null;
    private Process tail = null;
    private int size = 0;

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        size++;
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process current = head;
        Process previous = null;
        do {
            if (current.processID == processID) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    tail.next = head;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;

        Process current = head;
        while (completedProcesses < size) {
            if (current.burstTime > 0) {
                if (current.burstTime > timeQuantum) {
                    current.burstTime -= timeQuantum;
                    totalWaitingTime += timeQuantum * (size - completedProcesses - 1);
                } else {
                    totalWaitingTime += current.burstTime * (size - completedProcesses - 1);
                    totalTurnAroundTime += current.burstTime;
                    current.burstTime = 0;
                    completedProcesses++;
                    removeProcess(current.processID);
                }
            }
            current = current.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / size);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / size);
    }

    public void displayProcesses() {
        if (head == null) return;

        Process current = head;
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobin rr = new RoundRobin();
        Scanner scanner = new Scanner(System.in);

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);

        System.out.println("Processes in the circular queue:");
        rr.displayProcesses();

        System.out.println("Simulating Round Robin Scheduling with time quantum 4:");
        rr.simulateRoundRobin(4);

        System.out.println("Processes in the circular queue after simulation:");
        rr.displayProcesses();

        scanner.close();
    }
}