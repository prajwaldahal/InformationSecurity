public class CaeserCipher {
    public static void main(String[] args) {
        String msg= "abcdefghiz";
        int key = 1;
        String encryptedMessage=encryptMessage(msg,key);
        System.out.println("Encrypted Message "+encryptedMessage);
        String decryptedMessage=decryptMessage(encryptedMessage,key);
        System.out.println("decrypted Message "+decryptedMessage);
    }

    private static String decryptMessage(String encryptedMessage, int key) {
        StringBuilder decryptedMessage= new StringBuilder();
        for (char ch : encryptedMessage.toUpperCase().toCharArray()) {
             int positionAlphabet= ch-'A';
            int compute =(positionAlphabet-key+26) % 26;
            char alphabet= (char)(compute+'A');
            System.out.format("position=%d,compute=%d\n",positionAlphabet,compute);
            decryptedMessage.append(alphabet);
        }
        return decryptedMessage.toString();
    }

    private static String encryptMessage(String msg, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for(char ch: msg.toUpperCase().toCharArray()){
            int positionAlphabet= ch-'A';
            int compute =(positionAlphabet+key) % 26;
            char alphabet= (char)(compute+'A');
            encryptedMessage.append(alphabet);
        }
        return encryptedMessage.toString();
    }


}
