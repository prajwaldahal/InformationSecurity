import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Example {

    public static void main(String[] args) {
        String input = "Prajwal Dahal";
        String hashedOutput = hashSHA1(input);
        System.out.println("Input: " + input);
        System.out.println("SHA-1 Hash: " + hashedOutput);
    }

    public static String hashSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
