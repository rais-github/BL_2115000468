import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Set<String> languages = extractLanguages(text);
        System.out.println(String.join(", ", languages));
    }

    public static Set<String> extractLanguages(String text) {
        Set<String> languages = new HashSet<>();
        String[] knownLanguages = {"Java", "Python", "JavaScript", "Go", "C++", "C#", "Ruby", "Swift", "Kotlin", "PHP", "TypeScript", "Rust", "Scala", "Perl", "Haskell"};

        for (String language : knownLanguages) {
            Pattern pattern = Pattern.compile("\\b" + language + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                languages.add(language);
            }
        }
        return languages;
    }
}