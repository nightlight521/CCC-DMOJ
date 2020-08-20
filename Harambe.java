import java.util.*;
import java.io.*;

public class Harambe {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String input = bin.readLine().trim();
        int numUpper = 0;
        int numLower = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < 91 && (int) input.charAt(i) > 64) {
                numUpper++;
            } else if ((int) input.charAt(i) < 123 && (int) input.charAt(i) > 96) {
                numLower++;
            }
        }
        if (numUpper > numLower) {
            System.out.println(input.toUpperCase());
        } else if (numUpper < numLower) {
            System.out.println(input.toLowerCase());
        } else {
            System.out.println(input);
        }
    }
}