import java.util.*;
import java.io.*;

public class Summing {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        bin.readLine();
        String[] nums = bin.readLine().trim().split(" ");
        int[] sequence = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sequence[i] = Integer.parseInt(nums[i]);
        }
        long[] dp = new long[nums.length];
        for (int i = 0; i < sequence.length; i++) {
            if (i == 0) {
                dp[i] = Math.max(sequence[i], 0);
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(dp[0], sequence[i]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + sequence[i], dp[i - 2]));
        }
        System.out.println(dp[dp.length - 1]);
    }
}