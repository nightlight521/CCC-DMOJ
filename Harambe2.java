import java.util.*;
import java.io.*;

public class Harambe2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String original = bin.readLine().trim();
        String potentialCopy = bin.readLine().trim();
        int k = Integer.parseInt(bin.readLine().trim());
        for (int i = 0; i < original.length(); i++) {
            char originalChar = original.charAt(i);
            char potentialChar = potentialCopy.charAt(i);
            if (originalChar != potentialChar) {
                if (originalChar != ' ' && potentialChar != ' ') {
                    k--;
                }
                if (k < 0 || (originalChar == ' ' || potentialChar == ' ')) {
                    System.out.println("No plagiarism");
                    return;
                }
            }
        }
        System.out.println("Plagiarized");
    }
}
