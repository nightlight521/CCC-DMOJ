import java.util.*;
import java.io.*;

public class PerfectSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int numPerfectSquares = 0;
        for (int i = 0; i <= 100; i++) {
            int square = i * i;
            if (square > max) break;
            if (square >= min) {
                numPerfectSquares++;
            }
        }

        System.out.println(numPerfectSquares);
    }
}