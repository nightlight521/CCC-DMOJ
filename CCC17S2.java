import java.util.*;
import java.io.*;

public class CCC17S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        bin.readLine();
        String[] input = bin.readLine().trim().split(" ");
        int n = input.length;
        int[] measures = new int[n];
        for (int i = 0; i < n; i++) {
            measures[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(measures);
        int[] init = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = i % 2 == 0 ? measures[(n + 1)/2 - (1 + i/2)] : measures[(n + 1)/2 + i/2];
        }
        System.out.print(init[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + init[i]);
        }
        System.out.println();
    }
}