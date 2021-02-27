import java.util.*;
import java.io.*;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        String quiz = "";
        int q = 0;
        for (int i = 0; i < n; i++) {
            quiz = bin.readLine().trim();
            for (char c : quiz.toCharArray()) {
                if (c == 'C' || c == 'M') {
                    q++;
                }
            }
            if (q == 0) {
                System.out.println("PASS");
            } else if (q == 1) {
                System.out.println("FAIL");
            } else {
                System.out.println("NEGATIVE MARKS");
            }
            q = 0;
        }
    }
}