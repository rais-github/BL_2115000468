import java.io.*;
import java.nio.charset.StandardCharsets;

public class CompareStringAndFile {

    public static void main(String[] args) {
        
        String str = "hello";
        int iterations = 1_000_000;

        
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");

        String filePath = "./file.txt"; 

        
        try (FileReader fileReader = new FileReader(filePath)) {
            startTime = System.currentTimeMillis();
            int wordCount = countWords(fileReader);
            endTime = System.currentTimeMillis();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            startTime = System.currentTimeMillis();
            int wordCount = countWords(inputStreamReader);
            endTime = System.currentTimeMillis();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        int wordCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        return wordCount;
    }
}