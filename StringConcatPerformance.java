public class StringConcatPerformance {
    public static void main(String[] args) {
        int count = 1_000_000;
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = "a";
        }

        
        long startTime = System.currentTimeMillis();
        String result = "";
        for (String s : strings) {
            result += s;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using String: " + (endTime - startTime) + "ms");

        
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + "ms");

        
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : strings) {
            stringBuffer.append(s);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + "ms");
    }
}