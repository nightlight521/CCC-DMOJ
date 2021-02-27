import java.util.*;
import java.io.*;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int q = Integer.parseInt(input[0]);
        long[] all9Cases = {9L, 99L, 999L, 9999L, 99999L, 999999L, 9999999L, 99999999L, 999999999L,
                            9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L};
        for (int i = 0; i < q; i++) {
            int sum = 0;
            boolean carry = false;
            input = bin.readLine().trim().split(" ");
            String min = input[0];
            String max = input[1];
            int minLength = min.length();
            int maxLength = max.length();
            if (all9Cases[maxLength - 1] == Long.parseLong(max)) {
                System.out.println(maxLength * 9);
                return;
            } else if (maxLength == 1) {
                System.out.println(max);
                return;
            }
            int j = 0;
            if (minLength == maxLength){
                char curMinChar = min.charAt(j);
                char curMaxChar = max.charAt(j);
                while (curMinChar == curMaxChar && j < minLength) {
                    sum += Character.getNumericValue(curMaxChar);
                    j++;
                    if (j >= minLength) break;
                    curMinChar = min.charAt(j);
                    curMaxChar = max.charAt(j);
                }
            }
            if (j == 0) {
                sum += (maxLength - 1) * 9 + Character.getNumericValue(max.charAt(0)) - 1;
            } else if (j < maxLength - 1) {
                String left = max.substring(j);
                sum += all9Cases[left.length() - 1] == Long.parseLong(left) ?
                    left.length() * 9 : (maxLength - j - 1) * 9 + Character.getNumericValue(max.charAt(j)) - 1;
            } else if (j == maxLength - 1) {
                sum += Character.getNumericValue(max.charAt(j));
            }
            System.out.println(sum);
        }
    }
}