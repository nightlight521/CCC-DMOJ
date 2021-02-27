import java.util.*;
import java.io.*;

public class CCC17S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] a = new int[n];
        int aTotal = 0;
        int bTotal = 0;
        int maxDay = 0;
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            aTotal += a[i];
            bTotal += Integer.parseInt(input[i]);
            if (aTotal == bTotal) {
                maxDay = i + 1;
            }
        }
        System.out.println(maxDay);
    }
}