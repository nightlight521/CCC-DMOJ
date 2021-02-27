import java.util.*;
import java.io.*;

public class Love {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String s = bin.readLine().trim();
        long[][] DP = new long[s.length()][4];
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            for (int j = 0; j < 4; j++) {
                if (i == 0) break;
                DP[i][j] = DP[i - 1][j];
            }
            if (curChar == 'l') {
                DP[i][0] = i == 0 ? 1 : DP[i - 1][0] + 1;
            }
            if (i == 0) continue;
            if (curChar == 'o') {
                DP[i][1] = DP[i - 1][1] + DP[i][0];
            }
            if (curChar == 'v') {
                DP[i][2] = DP[i - 1][2] + DP[i][1];
            }
            if (curChar == 'e') {
                DP[i][3] = DP[i - 1][3] + DP[i][2];
            }
        }
        System.out.println(DP[s.length() - 1][3]);
    }
}