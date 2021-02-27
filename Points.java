import java.util.*;
import java.io.*;

public class Points {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] point = bin.readLine().trim().split(" ");
            points[i][0] = Integer.parseInt(point[0]);
            points[i][1] = Integer.parseInt(point[1]);
        }
        for (int i = 0; i < 5; i++) {
            String[] line = bin.readLine().trim().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            int a = y2 - y1;
            int c = x2 - x1;
            int b = y1 * c - x1 * a;

            int ptsOnLine = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if (y * c - x * a != b) continue;
                ptsOnLine++;
            }
            System.out.println(ptsOnLine);
        }
    }
}