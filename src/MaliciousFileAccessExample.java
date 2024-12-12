import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaliciousFileAccessExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to read: ");
        String filename = scanner.nextLine();
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        File file = new File(".\\src\\"+filename);;
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        scanner.close();
    }
}
