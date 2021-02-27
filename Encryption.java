import java.io.*;
import java.util.*;

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int columns = Integer.parseInt(bin.readLine().trim());
        while (columns != 0) {
            String coded = bin.readLine().trim();
            int rows = coded.length() / columns;
            char[][] arr = new char[rows][columns];
            int start = 0;
            boolean lr = true;
            for (int i = 0; i < rows; i++) {
                String curLine = coded.substring(start, start + columns);
                if (lr) {
                    for (int j = 0; j < columns; j++) {
                        arr[i][j] = curLine.charAt(j);
                    }
                } else {
                    int idx = 0;
                    for (int j = columns - 1; j >= 0; j--) {
                        arr[i][j] = curLine.charAt(idx);
                        idx++;
                    }
                }
                start += columns;
                lr = !lr;
            }
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(arr[j][i]);
                }
            }
            System.out.println();
            columns = Integer.parseInt(bin.readLine().trim());
        }
    }
}