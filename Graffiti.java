import java.util.*;
import java.io.*;

public class Graffiti {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String dmoj = "DMOJ";
        String s = bin.readLine().trim();
        int min = 3;
        if (s.equals("DMOJ")) {
            System.out.println(0);
            return;
        }
        String[] subsLength2 = {"MJ", "DM", "DO", "OJ", "DJ", "MO"};
        for (int i = 0; i <= s.length() - 2; i++) {
            for (int j = 0; j < subsLength2.length; j++) {
                if (s.substring(i, i + 2).equals(subsLength2[j])) {
                    min = 2;
                }
            }
        }
        String[] subsLength3 = {"MOJ", "DMO", "DMJ", "DOJ"};
        for (int i = 0; i <= s.length() - 3; i++) {
            for (int j = 0; j < subsLength3.length; j++) {
                if (s.substring(i, i + 3).equals(subsLength3[j])) {
                    min = 1;
                }
            }
        }
        System.out.println(min);
    }
}