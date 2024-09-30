import java.util.Scanner;

public class EuclideanAlgoritm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        int a = sc.nextInt();
        System.out.println("Enter a first number: ");
        int b = sc.nextInt();
        System.out.format("GCD of %d,%d is %d",a,b,calculateGCD(a,b));
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
           int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
