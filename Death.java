import java.util.*;
import java.io.*;

public class Death {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int t = Integer.parseInt(input[0]);
        input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int[][] possibles = new int[2 * n + 1][2 * n + 1];

        // Setup, marking how many seconds it takes for the square to be able to turn black
        for (int i = 0; i <= n; i++) {
            int max = 2 * n - i;
            for (int j = 0; j <= n; j++) {
                possibles[i][j] = max - j;
            }
            for (int j = 0; j < n; j++) {
                possibles[i][2 * n - j] = max - j;
            }
        }

        for (int i = 0; i <= n; i++) {
            int max = 2 * n - i;
            for (int j = 0; j <= n; j++) {
                possibles[2 * n - i][j] = max - j;
            }
            for (int j = 0; j < n; j++) {
                possibles[2 * n - i][2 * n - j] = max - j;
            }
        }

        // actual input, all we need to do now is check
        for (int i = 0; i < 2 * n + 1; i++) {
            input = bin.readLine().trim().split("");
            for (int j = 0; j < input.length; j++) {
                if ((input[j].equals("B") && possibles[i][j] > t) ||
                    (input[j].equals("W") && i == j && i == n && t == 0)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}