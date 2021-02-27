import java.util.*;
import java.io.*;

public class Ice {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int curX = 0;
        int curY = 0;
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        input = bin.readLine().trim().split(" ");
        HashSet<String> coords = new HashSet<>();
        coords.add(curX + " " + curY);
        for (int i = 0; i < input.length; i++) {
            String str = input[i];
            if (str.equals("L")) {
                curX++;
            } else if (str.equals("R")) {
                curX--;
            } else if (str.equals("U")) {
                curY++;
            } else {
                curY--;
            }
            if (coords.contains(curX + " " + curY)) {
                System.out.println("Fell at " + (i + 1));
                return;
            } else {
                coords.add(curX + " " + curY);
            }
        }
        System.out.println("Safe!");
    }
}