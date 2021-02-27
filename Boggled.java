import java.util.*;
import java.io.*;

public class Boggled {
    static int[][] dirs = {{0, 1},
                           {-1, 1},
                           {-1, 0},
                           {-1, -1},
                           {0, -1},
                           {1, -1},
                           {1, 0},
                           {1, 1}};
    static boolean findWord(String word, boolean[][] curPath, int[] curPos, char[][] board, int charPosInWord) {
        boolean foundAnyPath = false;
        if (charPosInWord == 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] != word.charAt(0)) continue;
                    curPath[i][j] = true;
                    curPos[0] = i;
                    curPos[1] = j;
                    if (findWord(word, curPath, curPos, board, charPosInWord + 1)) {
                        foundAnyPath = true;
                    }
                    curPath[i][j] = false;
                    curPos = new int[2];
                }
            }
            return foundAnyPath;
        }

        for (int[] dir : dirs) {
            int newX = curPos[0] + dir[0];
            int newY = curPos[1] + dir[1];
            if (newX > 3 || newX < 0 || newY > 3 || newY < 0 ||
                board[newX][newY] != word.charAt(charPosInWord) || curPath[newX][newY]) {
                continue;
            }
            if (charPosInWord == word.length() - 1) {
                return true;
            }
            curPath[newX][newY] = true;
            curPos[0] = newX;
 curPos[1] = newY;
            if (findWord(word, curPath, curPos, board, charPosInWord + 1)) {
                foundAnyPath = true;
                break;
            }
            curPath[newX][newY] = false;
            curPos[0] = newX - dir[0];
            curPos[1] = newY - dir[1];
        }
        return foundAnyPath;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            char[][] board = new char[4][4];
            for (int j = 0; j < 4; j++) {
                String line = bin.readLine().trim();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = line.charAt(k);
                }
            }
            int numWords = Integer.parseInt(bin.readLine().trim());
            int repeated = 0;
            int tooShort = 0;
            int notFound = 0;
            int points = 0;
            HashSet<String> uniqueWords = new HashSet<>();
            for (int j = 0; j < numWords; j++) {
                String word = bin.readLine().trim();
                
                if (word.length() < 3) {
                    tooShort++;
                    uniqueWords.add(word);
                    continue;
                }
                if (uniqueWords.contains(word)) {
                    repeated++;
                    continue;
                }
                if (!findWord(word, new boolean[4][4], new int[2], board, 0)) {
                    notFound++;
                    uniqueWords.add(word);
                    continue;
                }
                uniqueWords.add(word);
                if (word.length() < 5) {
                    points++;
                } else if (word.length() < 8) {
                    points += word.length() - 3;
                } else {
                    points += 11;
                }
            }
            int good = numWords - repeated - tooShort - notFound;
            System.out.println("Your score: " + points + " (" + good + " good, " + notFound + " not found, " +
                                tooShort + " too short, " + repeated + " repeated)");
        }
    }
}