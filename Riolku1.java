import java.util.*;
import java.io.*;

public class Riolku1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int c = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        String s = bin.readLine().trim();
        int cCount = 0;
        int vCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == 'y') {
                cCount++;
                vCount++;
            } else if (curChar == 'a' || curChar == 'e' || curChar == 'i' || curChar == 'o' ||
                    curChar == 'u') {
                cCount = 0;
                vCount++;
            } else {
                vCount = 0;
                cCount++;
            }
            if (cCount > c || vCount > v) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}