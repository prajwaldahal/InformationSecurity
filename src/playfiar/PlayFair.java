package playfiar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class PlayFair {
    static char[][] alphaMatrix = new char[5][5];

    public static void main(String[] args) {
        String key = "Monarchy";
        String text = "prajwgit al";

        String encryptedText = encryptText(text, key);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decryptText(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    private static String encryptText(String text, String key) {
        constructMatrix(key.replace(" ","").toUpperCase());
        ArrayList<String> pairedTexts = pairText(text.replace(" ","").toUpperCase());
        return convertToCipher(pairedTexts, true);
    }

    private static String decryptText(String text, String key) {
        constructMatrix(key.replace(" ","").toUpperCase());
        ArrayList<String> pairedTexts = pairText(text.replace(" ","").toUpperCase());
        String decryptedText = convertToCipher(pairedTexts, false);
        return removePadding(decryptedText);
    }

    private static String convertToCipher(ArrayList<String> pairedTexts, boolean isEncryption) {
        StringBuilder cipherTextBuilder = new StringBuilder();
        for (String pairedText : pairedTexts) {
            pairedText = pairedText.replace('J', 'I');
            char firstCharacter = pairedText.charAt(0);
            char secondCharacter = pairedText.charAt(1);
            Index indexFirst = findIndex(firstCharacter);
            Index indexSecond = findIndex(secondCharacter);
            assert indexFirst != null;
            assert indexSecond != null;

            if (indexFirst.getI() == indexSecond.getI()) {
                if (isEncryption) {
                    cipherTextBuilder.append(alphaMatrix[indexFirst.getI()][(indexFirst.getJ() + 1) % 5])
                            .append(alphaMatrix[indexSecond.getI()][(indexSecond.getJ() + 1) % 5]);
                } else {
                    cipherTextBuilder.append(alphaMatrix[indexFirst.getI()][(indexFirst.getJ() + 4) % 5])
                            .append(alphaMatrix[indexSecond.getI()][(indexSecond.getJ() + 4) % 5]);
                }
            } else if (indexFirst.getJ() == indexSecond.getJ()) {
                if (isEncryption) {
                    cipherTextBuilder.append(alphaMatrix[(indexFirst.getI() + 1) % 5][indexFirst.getJ()])
                            .append(alphaMatrix[(indexSecond.getI() + 1) % 5][indexSecond.getJ()]);
                } else {
                    cipherTextBuilder.append(alphaMatrix[(indexFirst.getI() + 4) % 5][indexFirst.getJ()])
                            .append(alphaMatrix[(indexSecond.getI() + 4) % 5][indexSecond.getJ()]);
                }
            } else {
                cipherTextBuilder.append(alphaMatrix[indexFirst.getI()][indexSecond.getJ()])
                        .append(alphaMatrix[indexSecond.getI()][indexFirst.getJ()]);
            }
        }
        return cipherTextBuilder.toString();
    }

    static Index findIndex(char pairedTextChar) {
        Index index = new Index();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pairedTextChar == alphaMatrix[i][j]) {
                    index.setI(i);
                    index.setJ(j);
                    return index;
                }
            }
        }
        return null;
    }

    private static ArrayList<String> pairText(String text) {
        char currentChar, nextChar;
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            currentChar = text.charAt(i);

            if (i != text.length() - 1)
                nextChar = text.charAt(i + 1);
            else {
                nextChar = currentChar;
            }
            if (currentChar != nextChar) {
                sb.append(currentChar).append(nextChar);
                i += 2;
            } else {
                sb.append(text.charAt(i)).append('X');
                i++;
            }
            arr.add(sb.toString());
            sb.delete(0, sb.length());
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
            if (i > 4)
                break;

            alphaMatrix[i][j] = ch;
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

    private static String removePadding(String text) {
        StringBuilder sb = new StringBuilder(text);
        if (sb.charAt(sb.length() - 1) == 'X') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
