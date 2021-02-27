import java.util.*;
import java.io.*;

public class CCC02S3 {
    static boolean isValidMove(int x, int y, char[][] yard) {
        if (x < 0 || y < 0 || x >= yard[0].length || y >= yard.length || yard[y][x] == 'X') return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        int[][] dirs = {{0, 1},
                        {1, 0},
                        {0, -1},
                        {-1, 0}};
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(bin.readLine().trim());
        int c = Integer.parseInt(bin.readLine().trim());
        char[][] yard = new char[r][c];
        for (int i = 0; i < r; i++) {
           yard[i] = bin.readLine().trim().toCharArray();
        }
        int numMoves = Integer.parseInt(bin.readLine().trim());
        String[] moves = new String[numMoves];
        for (int i = 0; i < numMoves; i++) {
            moves[i] = bin.readLine().trim();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (yard[i][j] == 'X') continue;
                for (int k = 0; k < dirs.length; k++) {
                    int dirIndex = k;
                    int x = j;
                    int y = i;
                    for (int l = 0; l < moves.length; l++) {
                        if (moves[l].equals("F")) {
                            x += dirs[dirIndex][0];
                            y += dirs[dirIndex][1];
                            if (!isValidMove(x, y, yard)) break;
                        } else {
                            dirIndex += moves[l].equals("L") ? 1 : -1;
                            dirIndex = (dirIndex + 4) % 4;
                        }
                    }
                    if (!isValidMove(x, y, yard)) continue;
                    yard[y][x] = '*';
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }
}
