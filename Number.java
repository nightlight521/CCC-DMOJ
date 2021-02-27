import java.util.*;
import java.io.*;

public class Number {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        int late = 0;
        int left = 0;
        String input = bin.readLine().trim();
        while (!input.equals("EOF")) {
            if (input.equals("TAKE")) {
                late++;
                left++;
                n = n == 999 ? 1 : n + 1;
            } else if (input.equals("SERVE")) {
                left--;
            } else if (input.equals("CLOSE")) {
                System.out.println(late + " " + left + " " + n);
                late = 0;
                left = 0;
            }
            input = bin.readLine().trim();
        }
    }
}