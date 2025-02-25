import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
        public class EncryptAndDecrypt {

            private static final String SECRET_KEY = "mySecretKey";

            public static void main(String[] args) {
                String filePath = "student.csv";
                List<String[]> data = new ArrayList<>();
                data.add(new String[]{"Name", "Salary", "Email"});
                data.add(new String[]{"John Doe", encrypt("50000"), encrypt("john.doe@example.com")});
                data.add(new String[]{"Jane Smith", encrypt("60000"), encrypt("jane.smith@example.com")});

                writeCSV(filePath, data);
                List<String[]> readData = readCSV(filePath);

                for (String[] row : readData) {
                    for (int i = 0; i < row.length; i++) {
                        if (i == 1 || i == 2) { // Decrypt Salary and Email fields
                            row[i] = decrypt(row[i]);
                        }
                    }
                    System.out.println(String.join(", ", row));
                }
            }

            private static String encrypt(String data) {
                return Base64.getEncoder().encodeToString((data + SECRET_KEY).getBytes());
            }

            private static String decrypt(String data) {
                byte[] decodedBytes = Base64.getDecoder().decode(data);
                String decodedString = new String(decodedBytes);
                return decodedString.substring(0, decodedString.length() - SECRET_KEY.length());
            }

            private static void writeCSV(String filePath, List<String[]> data) {
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
                    for (String[] row : data) {
                        writer.write(String.join(",", row));
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private static List<String[]> readCSV(String filePath) {
                List<String[]> data = new ArrayList<>();
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        data.add(line.split(","));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return data;
            }
        }
    