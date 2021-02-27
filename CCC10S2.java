import java.util.*;
import java.io.*;

public class CCC10S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int k = Integer.parseInt(input[0]);
        String[][] codes = new String[k][2];
        for (int i = 0; i < k; i++) {
            input = bin.readLine().trim().split(" ");
            codes[i][0] = input[1];
            codes[i][1] = input[0];
        }
        String binary = bin.readLine().trim();
        String answer = "";
        String cur = "";
        for (char c : binary.toCharArray()) {
            cur += c;
            for (String[] code : codes) {
                if (!code[0].equals(cur)) continue;
                answer += code[1];
                cur = "";
            }
        }
        System.out.println(answer);
    }
}