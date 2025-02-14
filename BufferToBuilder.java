public class BufferToBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "SampleText";

        
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ns");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ns");
    }
}