import java.util.*;
import java.io.*;

public class CCC10S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        String first = "";
        int firstScore = 0;
        String second = "";
        int secondScore = 0;
        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            int score = 2 * Integer.parseInt(input[1]) + 3 * Integer.parseInt(input[2]) + Integer.parseInt(input[3]);
            if (firstScore == 0) {
                first = input[0];
                firstScore = score;
            } else if (firstScore < score || (firstScore == score && input[0].compareTo(first) < 0)) {
                second = first;
                secondScore = firstScore;
                firstScore = score;
                first = input[0];
            } else if (secondScore < score || (secondScore == score && input[0].compareTo(second) < 0)) {
                second = input[0];
                secondScore = score;
            }
        }
        if (!first.equals("")) {
            System.out.println(first);
        }
        if (!second.equals("")) {
            System.out.println(second);
        }
    }
}