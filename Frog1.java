import java.util.*;
import java.io.*;

public class Frog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] heights = new int[n];
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }
        int[] minCosts = new int[n];
        minCosts[n - 1] = 0;
        minCosts[n - 2] = Math.abs(heights[n - 1] - heights[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            int step1Cost = Math.abs(heights[i + 1] - heights[i]);
            int step2Cost = Math.abs(heights[i + 2] - heights[i]);
            minCosts[i] = Math.min((step1Cost + minCosts[i + 1]), (step2Cost + minCosts[i + 2]));
        }
        System.out.println(minCosts[0]);
    }
}