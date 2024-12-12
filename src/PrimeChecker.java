import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number ");
        int number = scanner.nextInt();
        
        if (isPrime(number)) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is Composite.");
        }
        
        scanner.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= n/2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
