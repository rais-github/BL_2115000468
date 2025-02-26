import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonFilePath = "merged.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            if (content.trim().startsWith("{")) {
                new JSONObject(content);
            } else if (content.trim().startsWith("[")) {
                new JSONArray(content);
            } else {
                throw new JSONException("Invalid JSON format!");
            }

            System.out.println("✅ JSON is valid!");
        } catch (JSONException e) {
            System.out.println("❌ Invalid JSON! Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}
