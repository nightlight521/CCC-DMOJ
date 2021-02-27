import java.util.*;
import java.io.*;

public class Magic {
    public static void findMinApples(int product, int[] ponds) {
        if (ponds.length == 1) {
            System.out.println(1);
            return;
        }
        int xn = 1;
        while (true) {
            int end = ponds[ponds.length - 1] * xn;
            int temp = xn;
            if (end > product) {
                System.out.println("thonk");
            }
            for (int j = ponds.length - 2; j >= 0; j--) {
                if ((end + temp) % ponds[j] != 0) break;
                temp = (end + temp) / ponds[j];
                if (j == 0) {
                    System.out.println(temp);
                    return;
                }
            }
            xn++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(bin.readLine().trim());
            String[] input = bin.readLine().trim().split(" ");
            int[] ponds = new int[n];
            int product = 1;
            for (int j = 0; j < n; j++) {
                ponds[j] = Integer.parseInt(input[j]);
                product *= ponds[j];
            }
            findMinApples(product, ponds);
        }
    }
}