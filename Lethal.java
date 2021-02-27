import java.util.*;
import java.io.*;

public class Lethal {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int games = Integer.parseInt(input[0]);
        for (int i = 0; i < games; i++) {
            input = bin.readLine().trim().split(" ");
            int[] minions = new int[Integer.parseInt(input[0])];
            int totalAtk = 0;
            input = bin.readLine().trim().split(" ");
            for (int j = 0; j < minions.length; j++) {
                int minion = Integer.parseInt(input[j]);
                minions[j] = minion;
                totalAtk += minion;
            }
            input = bin.readLine().trim().split(" ");
            int health = Integer.parseInt(input[0]);
            int tauntHealth = Integer.parseInt(input[1]);

            int[] DP = new int[tauntHealth + 1];
            for (int j = 1; j < DP.length; j++) {
                DP[j] = totalAtk + 1;
            }
            for (int minionAtk : minions) {
                for (int k = tauntHealth; k > 0; k--) {
                    DP[k] = minionAtk >= k
                        ? Math.min(DP[k], minionAtk)
                        : Math.min(DP[k], minionAtk + DP[k - minionAtk]);
                }
            }
            if (totalAtk - DP[tauntHealth] < health) {
                System.out.println("NOT LETHAL");
                continue;
            }
            System.out.println("LETHAL");
        }
    }
}