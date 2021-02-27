import java.util.*;
import java.io.*;

public class SnakesLadders {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int curNum = 1;
        int move = Integer.parseInt(bin.readLine().trim());
        while (true) {
            if (move == 0) {
                System.out.println("You Quit!");
                return;
            }
            if (curNum + move <= 100) {
                curNum += move;
            }
            if (curNum == 100) {
                System.out.println("You are now on square 100");
                System.out.println("You Win!");
                return;
            }
            if (curNum == 54) {
                curNum = 19;
            } else if (curNum == 90) {
                curNum = 48;
            } else if (curNum == 99) {
                curNum = 77;
            } else if (curNum == 9) {
                curNum = 34;
            } else if (curNum == 40) {
                curNum = 64;
            } else if (curNum == 67) {
                curNum = 86;
            }
            System.out.println("You are now on square " + curNum);
            move = Integer.parseInt(bin.readLine().trim());
        }
    }
}