import java.util.*;
import java.io.*;

public class Entish {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = bin.readLine().trim().split("-");
        String newWord = "";
        String lastToken = "";
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            int tokenLength = token.length();
            boolean lastAddedVowel = false;
            String newToken = "";
            for (int j = 0; j < tokenLength; j++) {
                char curChar = token.charAt(j);
                if (curChar == 'a' || curChar == 'e' || curChar == 'i' ||
                    curChar == 'o' || curChar == 'u') {
                    newToken += curChar;
                    lastAddedVowel = true;
                } else if (j == 0 || lastAddedVowel) {
                    newToken += curChar;
                    lastAddedVowel = false;
                }
            }
            if (newToken.equals(lastToken)) continue;
            newWord += (newWord.length() == 0 ? "" : "-") + newToken;
            lastToken = newToken;
        }

        System.out.println(newWord);
    }
}