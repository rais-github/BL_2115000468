import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class TaskManagerTest {

    private final TaskManager taskManager = new TaskManager();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test will fail if it takes more than 2 seconds
    void testLongRunningTaskTimeout() {
        assertThrows(InterruptedException.class, () -> taskManager.longRunningTask());
    }
}
