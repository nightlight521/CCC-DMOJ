import java.util.*;
import java.io.*;

public class Traktor {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        HashMap<Integer, Integer> vertical = new HashMap<>();
        HashMap<Integer, Integer> horizontal = new HashMap<>();
        HashMap<Integer, Integer> pos1 = new HashMap<>();
        HashMap<Integer, Integer> neg1 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            vertical.put(x, vertical.containsKey(x) ? vertical.get(x) + 1 : 1);
            horizontal.put(y, horizontal.containsKey(y) ? horizontal.get(y) + 1 : 1);
            pos1.put(y - x, pos1.containsKey(y - x) ? pos1.get(y - x) + 1 : 1);
            neg1.put(y + x, neg1.containsKey(y + x) ? neg1.get(y + x) + 1 : 1);
            if (vertical.get(x) >= k || horizontal.get(y) >= k ||
                pos1.get(y - x) >= k || neg1.get(y + x) >= k) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}