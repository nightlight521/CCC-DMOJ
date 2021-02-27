import java.util.*;
import java.io.*;

public class Friendship {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        int iFirst = 0;
        int iSecond = 0;
        int iThird = 0;
        for (int i = 1; i <= n; i++) {
            input = bin.readLine().trim().split(" ");
            long iPoints = Integer.parseInt(input[1]);
            for (int j = 2; j < input.length; j++) {
                iPoints *= Integer.parseInt(input[j]);
            }
            if (iPoints > third) {
                third = iPoints;
                iThird = i;
            }
            if (iPoints > second) {
                third = second;
                iThird = iSecond;
                second = iPoints;
                iSecond = i;
            }
            if (iPoints > first) {
                second = first;
                iSecond = iFirst;
                first = iPoints;
                iFirst = i;
            }
        }
        System.out.println(iFirst);
        System.out.println(iSecond);
        System.out.println(iThird);
    }
}