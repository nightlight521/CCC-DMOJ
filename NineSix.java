import java.util.*;
import java.io.*;

public class NineSix {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bin.readLine().trim());
        int n = Integer.parseInt(bin.readLine().trim());
        int count = 0;
        for (; m <= n; m++) {
            String flipped = "";
            String cur = Integer.toString(m);
            for (int i = cur.length() - 1; i >= 0; i--) {
                char curChar = cur.charAt(i);
                if (curChar != '0' && curChar != '1' && curChar != '8' && curChar != '6' && curChar != '9') break;
                if (curChar == '6') {
                    flipped += '9';
                } else if (curChar == '9') {
                    flipped += '6';
                } else {
                    flipped += curChar;
                }
            }
            if (!flipped.equals(cur)) continue;
            count++;
        }
        System.out.println(count);
    }
}