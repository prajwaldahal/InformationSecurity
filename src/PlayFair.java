import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class PlayFair {
    static char[][] alphaMatrix = new char[5][5];

    public static void main(String[] args) {
        String key = "LUCK";
        String text = "OOFFICEF";
        encryptText(text, key);
    }

    private static void encryptText(String text, String key) {
        constructMatrix(key.replace(" ","").toUpperCase());
        ArrayList<String> strings = pairingText(text.replace(" ","").toUpperCase());
        ConvertToCipher(strings,alphaMatrix);
    }

    private static void ConvertToCipher(ArrayList<String> strings, char[][] alphaMatrix) {
        
    }

    private static ArrayList<String> pairingText(String text) {
       char currentChar,nextChar ;
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<text.length())
        {
            currentChar = text.charAt(i);

            if(i!=text.length()-1)
                nextChar = text.charAt(i+1);
            else{
                nextChar = currentChar;
            }
            System.out.println(i+" "+currentChar+nextChar);
            if (currentChar != nextChar) {
                sb.append(currentChar).append(nextChar);
                i+=2;
            }
            else{
                sb.append(text.charAt(i)).append('X');
                i++;
            }
            arr.add(sb.toString());
            sb.delete(0,sb.length());
        }
        return arr;
    }

    private static void constructMatrix(String key) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int i = 0, j = 0;

        for (int index = 0; index < key.length(); index++) {
            char currentChar = key.charAt(index);
            if (currentChar == 'J') currentChar = 'I';
            set.add(currentChar);
        }

        fillRemaining(set);

        for (char ch : set) {
            if (i > 4) break;

            alphaMatrix[i][j] = ch;
            //System.out.format("%s is stored in matrix index [%d,%d]\n", ch, i, j);

            j++;
            if (j == 5) {
                i++;
                j = 0;
            }
        }
    }

    private static void fillRemaining(HashSet<Character> set) {
        for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
            if (alpha == 'J') continue;
            set.add(alpha);
        }
    }


}
