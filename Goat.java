import java.util.*;
import java.io.*;

public class Goat {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        System.out.println(2 * n + 2);
    }
}