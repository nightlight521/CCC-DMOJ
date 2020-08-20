import java.util.*;
import java.io.*;

class OneV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        input = bin.readLine().trim().split(" ");
        int[] acorns = new int[n];
        for (int i = 0; i < n; i++) {
            acorns[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(acorns);

        int price = 0;
        int maxSets = 0;
        int copiesForSize = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || acorns[i] != acorns[i + 1]) {
                copiesForSize = 1;
            } else {
                copiesForSize++;
            }
            if (copiesForSize > maxSets) {
                maxSets++;
                price += acorns[i];
            }
        }
        System.out.println(price);
    }
}