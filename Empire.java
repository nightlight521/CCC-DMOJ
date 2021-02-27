import java.util.*;
import java.io.*;

public class Empire {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int total = 0;
        for (int i = 0; i < n; i++) {
            int rock = Integer.parseInt(bin.readLine().trim());
            if (rock <= m) {
                total += rock;
            }
        }
        System.out.println(total);
    }
}