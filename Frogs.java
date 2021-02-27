import java.io.*;
import java.util.*;

public class Frogs {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(bin.readLine().trim());
        long total = 0;
        if (n % 2 == 0) {
            total = (n / 2) * (1 + (n - 1));
        } else {
            total = ((n - 1) / 2) * (2 + (n - 1));
        }
        System.out.println(total);
    }
}