import java.util.*;
import java.io.*;

public class CCC02S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int numerator = Integer.parseInt(bin.readLine().trim());
        int denominator = Integer.parseInt(bin.readLine().trim());

        String answer = "0";
        int whole = 0;
        while (numerator >= denominator) {
            numerator -= denominator;
            whole++;
        }
        if (whole > 0) {
            answer = "" + whole;
        }
        if (numerator != 0) {
           for (int i = 2; i <= numerator; i++) {
               if (numerator % i != 0 || denominator % i != 0) continue;
               numerator /= i;
               denominator /= i;
           }
           if (whole > 0) {
               answer += " " + numerator + "/" + denominator;
           } else {
               answer = numerator + "/" + denominator;
           }
        }
        System.out.println(answer);
    }
}