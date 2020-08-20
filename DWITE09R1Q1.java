import java.util.*;
import java.io.*;

class iProfits {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = bin.readLine().trim();
            int n = Integer.parseInt(input);
            System.out.println((int)(Math.ceil(n/693.0) * 1000));
        }
    }
}