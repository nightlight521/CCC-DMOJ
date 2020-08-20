import java.util.*;
import java.io.*;

class NinePacksV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int h = Integer.parseInt(input[0]);
        int[] dogs = new int[h];
        for (int i = 0; i < h; i++) {
            dogs[i] = Integer.parseInt(input[i + 1]);
        }
        input = bin.readLine().trim().split(" ");
        int b = Integer.parseInt(input[0]);
        int[] buns = new int[b];
        for (int i = 0; i < b; i++) {
            buns[i] = Integer.parseInt(input[i + 1]);
        }

        int[] bunDP = new int[100001];
        int[] dogDP = new int[100001];

        for (int i = 1; i < 100001; i++) {
            dogDP[i] = h + b + 1;
            bunDP[i] = h + b + 1;
        }

        for (int i = 0; i < h; i++) {
            for (int j = dogDP.length - 1; j >= dogs[i]; j--) {
                dogDP[j] = Math.min(dogDP[j], dogDP[j - dogs[i]] + 1);
            }
        }

        for (int i = 0; i < b; i++) {
            for (int j = bunDP.length - 1; j >= buns[i]; j--) {
                bunDP[j] = Math.min(bunDP[j], bunDP[j - buns[i]] + 1);
            }
        }

        int minPacks = dogDP[1] + bunDP[1];
        for (int i = 2; i < 100001; i++) {
            minPacks = Math.min(minPacks, dogDP[i] + bunDP[i]);
        }
        if (minPacks >= h + b + 1) {
            System.out.println("impossible");
        } else {
            System.out.println(minPacks);
        }
    }
}