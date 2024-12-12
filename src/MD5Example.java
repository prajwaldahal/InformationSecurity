import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {

    public static void main(String[] args) {
        String input = "Prajwal Dahal";
        String hashedOutput = hashMD5(input);
        System.out.println("Input: " + input);
        System.out.println("MD5 Hash: " + hashedOutput);
    }

    public static String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
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
