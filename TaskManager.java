public class TaskManager {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulates a long task (3 seconds)
        return "Task Completed";
    }
}
