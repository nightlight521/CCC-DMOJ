import java.util.*;
import java.io.*;

public class CCC04S1 {
    public static boolean isFixFree(String word1, String word2) {
        String longer = word1.length() >= word2.length() ? word1 : word2;
        String shorter = longer.equals(word1) ? word2 : word1;
        if (longer.substring(0, shorter.length()).equals(shorter) ||
            longer.substring(longer.length() - shorter.length()).equals(shorter)) {
           return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        for (int i = 0; i < n; i++) {
            String s1 = bin.readLine().trim();
            String s2 = bin.readLine().trim();
            String s3 = bin.readLine().trim();
            if (!isFixFree(s1, s2) || !isFixFree(s1, s3) || !isFixFree(s2, s3)) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }
    }
}