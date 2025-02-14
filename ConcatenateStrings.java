public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!", " ", "Welcome", " ", "to", " ", "Java", "."};
        StringBuffer stringBuffer = new StringBuffer();

        for (String str : strings) {
            stringBuffer.append(str);
        }

        String concatenatedString = stringBuffer.toString();
        System.out.println(concatenatedString);
    }
}