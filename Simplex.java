import java.util.*;
import java.io.*;

public class Simplex {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String input = bin.readLine().trim();
        int numCases = Integer.parseInt(input);
        for (int i = 0; i < numCases; i++) {
            input = bin.readLine().trim();
            long numEdges = Long.parseLong(input);
            long answer = (long)Math.ceil((1 + Math.sqrt(1 + 8 * numEdges))/2);
            long maxEdges = answer * (answer-1) / 2;
            System.out.println(maxEdges >= numEdges ? answer : answer + 1);
        }
    }
}