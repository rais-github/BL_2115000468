import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLink {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern = Pattern.compile("https?://\\S+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
