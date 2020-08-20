import java.util.*;
import java.io.*;

public class Frog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] heights = new int[n];
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }                                                                                                                                                            int[] minCosts = new int[n];
        minCosts[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curMinCost = -1;
            for (int j = 1; j <= k; j++) {
                if (i + j > n - 1) break;
                int stepCost = Math.abs(heights[i + j] - heights[i]);
                if (curMinCost == -1) {
                    curMinCost = stepCost + minCosts[i + j];
                } else {
                    curMinCost = Math.min(curMinCost, stepCost + minCosts[i + j]);
                }
            }
            minCosts[i] = curMinCost;
        }
        System.out.println(minCosts[0]);
    }
}