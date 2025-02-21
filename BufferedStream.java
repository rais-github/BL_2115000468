import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {
        String sourceFile = "./bsb.docx";
        String destFileBuffered = "./bsb_copy.docx";
        String destFileUnbuffered = "./bsb_copy_unbuffered.docx";

        try {
            // Copy using buffered streams
            long startTime = System.nanoTime();
            copyFileUsingBufferedStreams(sourceFile, destFileBuffered);
            long endTime = System.nanoTime();
            System.out.println("Buffered Streams Time: " + (endTime - startTime) + " ns");

            // Copy using unbuffered streams
            startTime = System.nanoTime();
            copyFileUsingUnbufferedStreams(sourceFile, destFileUnbuffered);
            endTime = System.nanoTime();
            System.out.println("Unbuffered Streams Time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileUsingBufferedStreams(String source, String dest) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void copyFileUsingUnbufferedStreams(String source, String dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
