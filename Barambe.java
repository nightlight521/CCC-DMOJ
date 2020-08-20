import java.io.*;
import java.util.*;

public class Barambe {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        String fixed = input[0];
        for (int i = 1; i < input.length; i++) {
            int firstLetter = input[i].charAt(0);
            if (firstLetter > 64 && firstLetter < 91) {
                fixed += ".";
            }
            fixed = fixed + " " + input[i];
        }
        fixed += ".";
        System.out.println(fixed);
    }
}