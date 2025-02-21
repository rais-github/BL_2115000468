import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class InterThreadCommunication {

    public static void main(String[] args) {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();

        try {
            
            inputStream.connect(outputStream);

            
            Thread writerThread = new Thread(new Writer(outputStream));
            Thread readerThread = new Thread(new Reader(inputStream));

            
            writerThread.start();
            readerThread.start();

            
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream outputStream;

    public Writer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                outputStream.write(("Message " + i + "\n").getBytes());
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Reader implements Runnable {
    private PipedInputStream inputStream;

    public Reader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}