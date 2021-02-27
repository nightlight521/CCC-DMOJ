import java.util.*;
import java.io.*;

public class Valentine {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        long n = Long.parseLong(input[0]);
        HashMap<Integer, Integer> totalForSlope = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Long>> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            int m = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (totalForSlope.get(m) == null) {
                totalForSlope.put(m, 1);
            } else {
                totalForSlope.put(m, totalForSlope.get(m) + 1);
            }
            if (storage.get(m) == null) {
                storage.put(m, new HashMap<Integer, Long>());
            }
            HashMap<Integer, Long> bMap = storage.get(m);
            if (bMap.get(b) != null) {
                bMap.put(b, bMap.get(b) + 1);
            } else {
                bMap.put(b, 1L);
            }
        }

        long totalPossible = n * (n - 1) / 2;
        long counter = 0;
        for (Integer m : storage.keySet()) {
            int counted = 0;
            HashMap<Integer, Long> bMap = storage.get(m);
            for (Integer b : bMap.keySet()) {
                long bNum = bMap.get(b);
                counter += bNum * (totalForSlope.get(m) - counted - bNum);
                counted += bNum;
            }
        }
        
        if (totalPossible < 0) {
            System.out.println(n);
            System.out.println(totalPossible);
        } else if (counter > totalPossible) {
            System.out.println("b");
        }
        System.out.println(totalPossible - counter);
    }
}