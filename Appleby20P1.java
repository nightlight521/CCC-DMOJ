import java.util.*;
import java.io.*;

public class Appleby20P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int t = (Integer.parseInt(input[0]));
        long[] arr = new long[3];
        String[] answers = new String[t];
        for (int i = 0; i < t; i++) {
            input = bin.readLine().trim().split(" ");
            arr[0] = Long.parseLong(input[0]);
            arr[1] = Long.parseLong(input[1]);
            arr[2] = Long.parseLong(input[2]);
            Arrays.sort(arr);
            long a = arr[0] * arr[0];
            long b = arr[1] * arr[1];
            long c = arr[2] * arr[2];
            if (a + b == c) {
                answers[i] = "R";
            } else if (a + b < c) {
                answers[i] = "O";
            } else {
                answers[i] = "A";
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(answers[i]);
        }
    }
}