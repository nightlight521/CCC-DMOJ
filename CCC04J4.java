import java.util.*;
import java.io.*;

public class CCC04J4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String keyword = bin.readLine().trim();
        String message = bin.readLine().trim();

        int keywordIndex = 0;
        String encoded = "";
        for (int i = 0; i < message.length(); i++) {
            char curChar = message.charAt(i);
            if (curChar < 'A' || curChar > 'Z') continue;
            char encodedChar = (char) (curChar + keyword.charAt(keywordIndex) - 'A');
            if (encodedChar > 'Z') {
                encodedChar = (char) (encodedChar - 26);
            }
            encoded += encodedChar;
            keywordIndex = (keywordIndex + 1 + keyword.length()) % keyword.length();
        }
        System.out.println(encoded);
    }
}