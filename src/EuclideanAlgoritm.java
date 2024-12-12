import java.util.Scanner;

public class EuclideanAlgoritm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        long  a = sc.nextLong();
        System.out.println("Enter a second number: ");
        long  b = sc.nextLong();
        System.out.format("GCD of %d,%d is %d",a,b,calculateGCD(a,b));
    }

    public static long calculateGCD(long a, long b) {
        long  c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
