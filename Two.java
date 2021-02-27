import java.util.*;
import java.io.*;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int[] trolleys = new int[n];
        //int[] days = new int[d];
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            trolleys[i] = Integer.parseInt(input[i]);
        }
        int m = 0;
        int f = 0;
        int s = 0;
        for (int i = 0; i < d; i++) {
            m = Integer.parseInt(bin.readLine().trim());
            int[] fArr = new int[m];
            int[] sArr = new int[n - m];
            for (int j = 0; j < m; j++) {
                f += trolleys[j];
                fArr[j] = trolleys[j];
            }
            for (int j = m; j < trolleys.length; j++) {
                s += trolleys[j];
                sArr[j - m] = trolleys[j];
            }
            if (f >= s) {
                trolleys = sArr;
                System.out.println(f);
            } else {
                trolleys = fArr;
                System.out.println(s);
            }
            f = 0;
            s = 0;
        }
    }
}