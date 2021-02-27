import java.util.*;
import java.io.*;

public class CCC17S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        bin.readLine();
        String[] input = bin.readLine().trim().split(" ");
        int n = input.length;
        // associates board segment lengths to # of boards that length
        int[] lengths = new int[2001];
        // associates fence heights to fence lengths
        int[] heights = new int[4001];
        // associates fence lengths to number of variants
        int[] variants = new int[n + 1];
        int max = 0;
        ArrayList<Integer> curHeights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(input[i]);
            if (lengths[cur] == 0) {
                curHeights.add(cur);
            }
            lengths[cur]++;
        }
        for (int i = 0; i < curHeights.size(); i++) {
            int a = curHeights.get(i);
            for (int j = i + 1; j < curHeights.size(); j++) {
                int b = curHeights.get(j);
                if (heights[a + b] != 0) {
                    variants[heights[a + b]]--;
                }
                heights[a + b] += Math.min(lengths[a], lengths[b]);
                variants[heights[a + b]]++;
                max = Math.max(max, heights[a + b]);
            }
            if (lengths[a] == 1) continue;
            if (heights[a * 2] != 0) {
                variants[heights[a * 2]]--;
            }
            heights[a * 2] += lengths[a] / 2;
            variants[heights[a * 2]]++;
            max = Math.max(max, heights[a * 2]);
        }
        System.out.println(max + " " + variants[max]);
    }
}