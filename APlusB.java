import java.util.*;
import java.io.*;

public class APlusB {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            System.out.println(a + b);
        }
    }
}