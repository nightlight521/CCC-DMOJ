import java.util.*;
import java.io.*;

public class CCC03S2 {
    static String findLastSyllable(String s) {
        String lastSyllable = "";
        boolean foundVowel = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' || foundVowel) return lastSyllable;
            char curChar = s.charAt(i);
            if (curChar == 'a' || curChar == 'e' || curChar == 'i' || curChar == 'o' || curChar == 'u') {
                foundVowel = true;
            }
            lastSyllable += s.charAt(i);
        }
        return lastSyllable;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        for (int i = 0; i < n; i++) {
            String s1 = findLastSyllable(bin.readLine().trim().toLowerCase());
            String s2 = findLastSyllable(bin.readLine().trim().toLowerCase());
            String s3 = findLastSyllable(bin.readLine().trim().toLowerCase());
            String s4 = findLastSyllable(bin.readLine().trim().toLowerCase());
            if (s1.equals(s2) && s1.equals(s3) && s1.equals(s4)) {
                System.out.println("perfect");
            } else if (s1.equals(s2) && s3.equals(s4)) {
                System.out.println("even");
            } else if (s1.equals(s3) && s2.equals(s4)) {
                System.out.println("cross");
            } else if (s1.equals(s4) && s2.equals(s3)) {
                System.out.println("shell");
            } else {
                System.out.println("free");
            }
        }
    }
}