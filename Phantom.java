import java.util.*;
import java.io.*;

public class Phantom {
    public static int getColumn(int i, boolean prev) {
        if (i % 2 == 0) {
            if (prev) {
                return 1;
            }
            return 0;
        }
        if (prev) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] ghosts = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            input = bin.readLine().trim().split(" ");
            ghosts[i][0] = Integer.parseInt(input[0]);
            ghosts[i][1] = Integer.parseInt(input[1]);
        }

        // initiliaze the dp array with the base cases:
        // if there are no ghosts to banish, ghosts banished = 0 and points left doesn't change
        int[][][] dp = new int[2][10001][2];
        for (int i = 0; i < 10001; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = i;
        }

        // dp:
        // Let s represent the cost of one ghost, and g the points gained from said ghost.
        // With j points and at i ghosts from the end, the optimal solution in terms of ghosts and points is:
        // a) if we defeat the ith ghost:
        //      # of ghosts = # banished at i-1 ghosts from the end and j-s+g points, + 1
        //      # of points = # at ^^ solution
        // b) if we don't defeat the ith ghost
        //      # of ghosts = # banished at i-1 ghosts from the end and j points
        //      # of points = # at ^^ solution
        // compare these two and maximize # of ghosts defeated, and # of points remaining secondarily
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 10001; j++) {
                int pastColumn = getColumn(i, true);
                int column = getColumn(i, false);

                int[] b = dp[pastColumn][j];
                int[] ghost = ghosts[(n + 1) - i];
                // if we don't have enough points to banish the ghost don't even consider it
                if (j < ghost[0]) {
                    dp[column][j][0] = b[0];
                    dp[column][j][1] = b[1];
                    continue;
                }

                // impossible case, ignore (also would cause array index out of bounds)
                if (j - ghost[0] + ghost[1] > 10000) continue;
 int[] prev = dp[pastColumn][j - ghost[0] + ghost[1]];
                int g = prev[0] + 1;
                int p = prev[1];
                if (g > b[0] || (g == b[0] && p > b[1])) {
                    dp[column][j][0] = g;
                    dp[column][j][1] = p;
                } else {
                    dp[column][j][0] = b[0];
                    dp[column][j][1] = b[1];
                }
                if (i == n + 1 && j == m + 1) break;
            }
        }
        System.out.println(dp[getColumn(n, false)][m][0] + " " + dp[getColumn(n, false)][m][1]);
    }
}