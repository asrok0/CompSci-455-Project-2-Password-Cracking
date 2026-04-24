import java.security.MessageDigest;

// Util class to generate hashes
public class MD5Util {

    // Converts plaintext to hash
    public static String md5(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes("ASCII"));
            StringBuilder sb = new StringBuilder();

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}