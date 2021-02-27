import java.util.*;
import java.io.*;

public class Substrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String s = bin.readLine().trim();
        int k = Integer.parseInt(bin.readLine().trim());
        int ans = 0;
        int count = 0;
        char trackChar = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == trackChar) {
                count++;
                if (count == k) {
                    ans++;
                    count--;
                }
            } else {
                trackChar = curChar;
                count = 1;
            }
        }
        System.out.println(ans);
    }
}