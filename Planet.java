import java.util.*;
import java.io.*;

public class Planet {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int planet = Integer.parseInt(bin.readLine().trim());
            if (seen.containsKey(planet)) {
                System.out.println(seen.get(planet));
                seen.put(planet, seen.get(planet) + 1);
            } else {
                System.out.println(0);
                seen.put(planet, 1);
            }
        }
        System.out.println(seen.size());
    }
}