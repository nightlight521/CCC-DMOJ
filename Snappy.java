import java.util.*;
import java.io.*;

public class Snappy {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int closest = n;
        while (n > 0) {
           int newN = n/2;
           if (Math.abs(newN - m) < Math.abs(n - m)) {
               closest = newN;
           }
           n = newN;
        }
        System.out.println(closest);
    }
}