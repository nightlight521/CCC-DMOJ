import java.util.*;
import java.io.*;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        String[] input = bin.readLine().trim().split(" ");
        int m = Integer.MIN_VALUE;
        int mIndex = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
            if (a[i] > m) {
                m = a[i];
                mIndex = i;
            }
        }

        long seconds = 0;
        int mUp = Integer.MIN_VALUE;
        for (int i = 0; i < mIndex; i++) {
            if (a[i] > mUp) {
                mUp = a[i];
            } else if (a[i] < mUp) {
                seconds += mUp - a[i];
            }
        }
        mUp = Integer.MIN_VALUE;
        for (int i = n - 1; i > mIndex; i--) {
            if (a[i] > mUp) {
                mUp = a[i];
            } else if (a[i] < mUp) {
                seconds += mUp - a[i];
            }
        }

        System.out.println(seconds);
    }
}