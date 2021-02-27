import java.util.*;
import java.io.*;

public class Checklist {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<String> items = new HashSet<>();
        for (int i = 0; i < n; i++) {
            items.add(bin.readLine().trim());
        }

        int canComplete = 0;
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(bin.readLine().trim());
            int have = 0;
            for (int j = 0; j < t; j++) {
                if (items.contains(bin.readLine().trim())) {
                    have++;
                }
            }
            if (have != t) continue;
            canComplete++;
        }
        System.out.println(canComplete);
    }
}