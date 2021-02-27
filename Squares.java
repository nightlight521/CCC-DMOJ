import java.util.*;
import java.io.*;

public class Squares {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int h = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        input = bin.readLine().trim().split(" ");
        ArrayList<Integer> hLines = new ArrayList<>();
        HashMap<Integer, Integer> deltaHs = new HashMap<>();
        for (int i = 0; i < h; i++) {
            int newH = Integer.parseInt(input[i]);
            for (int hLine : hLines) {
                int deltaH = newH - hLine;
                if (deltaHs.containsKey(deltaH)) {
                    deltaHs.put(deltaH, deltaHs.get(deltaH) + 1);
                } else {
                    deltaHs.put(deltaH, 1);
                }
            }
            hLines.add(newH);
        }
        int squares = 0;
        ArrayList<Integer> vLines = new ArrayList<>();
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < v; i++) {
            int newV = Integer.parseInt(input[i]);
            for (int vLine : vLines) {
                int deltaV = newV - vLine;
                if (deltaHs.containsKey(deltaV)) {
                    squares += deltaHs.get(deltaV);
                }
            }
            vLines.add(newV);
        }
        System.out.println(squares);
    }
}