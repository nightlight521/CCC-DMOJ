import java.util.*;
import java.io.*;

public class Salt {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        HashSet<String> coords = new HashSet<>();
        HashMap<Integer, Integer> xNums = new HashMap<>();
        HashMap<Integer, Integer> yNums = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String full = bin.readLine().trim();
            input = full.split(" ");
            coords.add(full);
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if (xNums.containsKey(x)) {
                xNums.put(x, xNums.get(x) + 1);
            } else {
                xNums.put(x, 1);
            }
            if (yNums.containsKey(y)) {
                yNums.put(y, yNums.get(y) + 1);
            } else {
                yNums.put(y, 1);
            }
        }

        for (int i = 0; i < q; i++) {
            input = bin.readLine().trim().split(" ");
            int type = Integer.parseInt(input[0]);
            if (type == 1) {
                System.out.println(coords.contains(input[1] + " " + input[2]) ? "salty" : "bland");
            } else if (input[1].equals("X")) {
                int x = Integer.parseInt(input[2]);
                int num = 0;
                if (xNums.containsKey(x)) {
                    num = xNums.get(x);
                } else {
                    num = 0;
                }
                System.out.println(num);
            } else {
                int y = Integer.parseInt(input[2]);
                int num = 0;
                if (yNums.containsKey(y)) {
                    num = yNums.get(y);
                } else {
                    num = 0;
                }
                System.out.println(num);
            }
        }
    }
}