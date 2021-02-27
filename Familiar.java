import java.util.*;
import java.io.*;

public class Familiar {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        input = bin.readLine().trim().split(" ");
        int maxLength = 0;
        int runningLength = 0;
        long runningSum = 0;
        int startIdx = 0;
        int[] pencils = new int[n];
        for (int i = 0; i < input.length; i++) {
            int cuteness = Integer.parseInt(input[i]);
            pencils[i] = cuteness;
            runningSum += cuteness;
            runningLength++;
            if (runningSum < m) {
                maxLength = Math.max(maxLength, runningLength);
            }
            while (runningSum >= m) {
                runningSum -= pencils[startIdx];
                runningLength--;
                startIdx++;
            }
            maxLength = Math.max(maxLength, runningLength);
        }
        System.out.println(maxLength);
    }
}