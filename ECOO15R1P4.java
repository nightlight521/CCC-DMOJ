import java.util.*;
import java.io.*;

class Neanderthal {
    public static void main(String[] args) throws IOException {
        String[] words = {"ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug"};
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String input = bin.readLine().trim();
            int length = input.length();
            int[] waysFromLetter = new int[length + 1];
            waysFromLetter[length] = 1;
            for (int j = length - 2; j >= 0; j--) {
                for (String word : words) {
                    int wordLength = word.length();
                    if (wordLength > length - j) continue;
                    if (input.substring(j, j + wordLength).equals(word)) {
                        waysFromLetter[j] += waysFromLetter[j + wordLength];
                    }
                }
            }
            System.out.println(waysFromLetter[0]);
        }
    }
}