import java.util.Scanner;

public class PasswordAuthentication {
    public static void main(String[] args) {
        String storedPassword = "secret123";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (storedPassword.equals(enteredPassword)) {
            System.out.println("Password correct! Access granted.");
        } else {
            System.out.println("Incorrect password. Access denied.");
        }

        scanner.close();
    }
}
