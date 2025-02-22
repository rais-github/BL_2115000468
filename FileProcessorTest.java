import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFilename = "testfile.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Path.of(testFilename)); // Clean up before each test
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(testFilename)); // Clean up after each test
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(testFilename, content);

        String result = fileProcessor.readFromFile(testFilename);
        assertEquals(content, result, "The file content should match the written content");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(testFilename, "Some content");
        assertTrue(Files.exists(Path.of(testFilename)), "File should exist after writing");
    }

    @Test
    void testReadNonExistentFileThrowsIOException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("non_existent_file.txt"));
    }
}
