import java.util.regex.Pattern;

public class ValidateIP {
    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    public static boolean isValidIPv4(String ip) {
        if (ip == null) {
            return false;
        }
        return IPV4_PATTERN.matcher(ip).matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",
            "255.255.255.255",
            "0.0.0.0",
            "256.256.256.256",
            "192.168.1",
            "192.168.1.1.1",
            "192.168.01.1",
            "192.168.1.256"
        };

        for (String ip : testIPs) {
            System.out.println(ip + " is valid? " + isValidIPv4(ip));
        }
    }
}