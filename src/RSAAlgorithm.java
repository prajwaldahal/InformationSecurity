import java.math.BigInteger;

public class RSAAlgorithm {
    public static void main(String[] args) {
        long p = 67;
        long q = 71;
        long n = p * q;
        long nPrime = (p - 1) * (q - 1);

        long e = calculateE(nPrime);
        if(e==-1)
            throw new RuntimeException("Something went wrong");
        System.out.format("public key: {%d,%d}\n",e,n);

        long d=calculateD(e,nPrime);
        System.out.format("private key: {%d,%d}\n",d,n);

        int msg=13;
        String encrpytedText=encryptText(e,n,msg);
        System.out.println("Encrypted text: "+encrpytedText);
        String decryptedText=decryptText(d,n,encrpytedText);
        System.out.println("Decrpyted Text:"+decryptedText);
    }

    private static String decryptText(long d, long n, String encrpytedText) {
        BigInteger base=new BigInteger(encrpytedText);
        BigInteger exponent=new BigInteger(String.valueOf(d));
        BigInteger modulus=new BigInteger(String.valueOf(n));
        return base.modPow(exponent,modulus).toString();
    }

    private static String encryptText(long e, long n,int value) {
        BigInteger base=new BigInteger(String.valueOf(value));
        BigInteger expo=new BigInteger(String.valueOf(e));
        BigInteger modulus=new BigInteger(String.valueOf(n));
        return base.modPow(expo,modulus).toString();
    }


    private static long calculateE(long nPrime) {
        for (int i = 2; i < nPrime; i++) {
            long gcd=EuclideanAlgoritm.calculateGCD(nPrime, i);
            if(gcd==1)
                return i;
        }
        return -1;
    }

    private static long calculateD(long e, long nPrime) {
        long k=1;
        while(true){
           double result = (double) (nPrime * k + 1) / e;
           if(isWholeNumber(result) && result!=e){
               return (long) result;
           }
           k++;
        }
    }

    private static boolean isWholeNumber(double result){
        return result==Math.ceil(result);
    }
}
