import java.util.*;
import java.io.*;

public class Mario {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bin.readLine().trim());
        for (int i = 0; i < t; i++) {
            String[] startLevel = bin.readLine().trim().split("");
            int world = Integer.parseInt(startLevel[0]);
            int stage = Integer.parseInt(startLevel[2]);
            int levels = 33 - (world - 1) * 4 - stage;
            if (world == 1 && stage <= 2) {
                levels -= 10;
            }
            if (world < 4 || (world == 4 && stage <= 2)) {
                levels -= 14;
            }
            System.out.println(levels);
        }
    }
}