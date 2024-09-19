import java.util.Arrays;

public class RailFence {
    public static void main(String[] args) {
        String msg = "Welcome to 8th semester";
		int key=msg.length()/3+2;
        if (args.length > 0)
            msg = args[0];
        
        String encryptedMsg = encrypt(msg, key);
        System.out.println("Encrypted Message: " + encryptedMsg);
        
        String plainText = decrypt(encryptedMsg, key);
        System.out.println("Decrypted Message: " + plainText);
    }
    
    static String encrypt(String msg, int key) {
        if (key <= 1)
			return msg;
        
        StringBuilder[] rows = new StringBuilder[key];
        for (int i = 0; i < key; i++) {
            rows[i] = new StringBuilder();
        }
        
        int rowIndex = 0;
        boolean downDirection = true;
        
        for (char ch : msg.toCharArray()) {
            rows[rowIndex].append(ch);
            if (rowIndex == 0) downDirection = true;
            else if (rowIndex == key - 1) downDirection = false;
            
            rowIndex += downDirection ? 1 : -1;
        }
        
        StringBuilder encryptedMsg = new StringBuilder();
        for (StringBuilder row : rows) {
            encryptedMsg.append(row);
        }
        
        return encryptedMsg.toString();
    }
    
    static String decrypt(String encryptedMsg, int key) {
        if (key <= 1) 
			return encryptedMsg;
        
        int[] rowLengths = new int[key];
        int rowIndex = 0;
        boolean downDirection = true;
        
        
        for (int i = 0; i < encryptedMsg.length(); i++) {
            rowLengths[rowIndex]++;
            if (rowIndex == 0) downDirection = true;
            else if (rowIndex == key - 1) downDirection = false;
            
            rowIndex += downDirection ? 1 : -1;
        }
        
		
		
        char[][] rows = new char[key][];
        int currentIndex = 0;
        
        for (int i = 0; i < key; i++) {
            rows[i] = encryptedMsg.substring(currentIndex, currentIndex + rowLengths[i]).toCharArray();
            currentIndex += rowLengths[i];
        }
        
        StringBuilder plainText = new StringBuilder();
        rowIndex = 0;
        downDirection = true;
        int[] rowIndexTracker = new int[key];
        
        for (int i = 0; i < encryptedMsg.length(); i++) {
            plainText.append(rows[rowIndex][rowIndexTracker[rowIndex]++]);
            if (rowIndex == 0) downDirection = true;
            else if (rowIndex == key - 1) downDirection = false;
            
            rowIndex += downDirection ? 1 : -1;
        }
        
        return plainText.toString();
    }
}
