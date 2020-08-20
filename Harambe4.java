import java.util.*;
import java.io.*;

public class Harambe4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        bin.readLine();
        String[] replacements = bin.readLine().trim().split(" ");
        int maxLength = bin.readLine().trim().length();
        String newWord = "";
        for (String replacement : replacements) {
            if (replacement.length() > maxLength) continue;
            if (replacement.length() > newWord.length()) {
                newWord = replacement;
            }
        }
        System.out.println(newWord);
    }
}