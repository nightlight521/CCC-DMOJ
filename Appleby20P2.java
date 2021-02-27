import java.util.*;
import java.io.*;

public class Appleby20P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        long playdoughs[] = new long[100001];
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(input[i]);
            playdoughs[weight] += 1;
        }
        ArrayList<Long> answers = new ArrayList<Long>();
        for (int i = 0; i < q; i++) {
            input = bin.readLine().trim().split(" ");
            int type = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);
            if (type == 1) {
                long curNum = playdoughs[weight];
                if (weight % 2 == 0) {
                    playdoughs[weight / 2] += 2 * curNum;
                } else {
                    playdoughs[weight / 2] += curNum;
                    playdoughs[weight / 2 + 1] += curNum;
                }
                playdoughs[weight] = 0;
                continue;
            }
            answers.add(playdoughs[weight]);
        }
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}