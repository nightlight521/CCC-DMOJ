import java.util.*;
import java.io.*;

public class Crayola {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        String[] input = bin.readLine().trim().split(" ");
        HashSet<String> colours = new HashSet<>();
        HashMap<String, Integer> code = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (colours.add(input[i])) {
                code.put(input[i], colours.size() - 1);
            }
        }
        int[] markers = new int[colours.size()];
        for (int i = 0; i < input.length; i++) {
            markers[code.get(input[i])]++;
        }

        int sum = 0;
        Arrays.sort(markers);
        for (int i = 0; i < markers.length - 1; i++) {
            sum += markers[i];
        }
        System.out.println(markers[markers.length - 1] > sum + 1 ? sum * 2 + 1 : sum + markers[markers.length  - 1]);
    }
}