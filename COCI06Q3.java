import java.util.*;

public class Okviri{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        char[][] template = {
            {'.', '.', '#', '.', '.'},
            {'.', '#', '.', '#', '.'},
            {'#', '.', 'x', '.', '#'},
            {'.', '#', '.', '#', '.'},
            {'.', '.', '#', '.', '.'},
        };
        char[][] framed = new char[5][4*word.length() + 1];
        for (int i = 0; i < word.length(); i++) {
           char frameChar = i%3 == 2 ? '*' : '#';
           int startColumn = i*4;
           for (int j = 0; j < 5; j++) {
               for (int k = 0; k < 5; k++) {
                  if (framed[j][startColumn + k] == '*') continue;
                  if (template[j][k] == 'x') {
                      framed[j][startColumn + k] = word.charAt(i);
                  } else if (template[j][k] == '#') {
                      framed[j][startColumn + k] = frameChar;
                  } else {
                      framed[j][startColumn + k] = '.';
                  }
               }
           }
        }
        for (char[] row : framed) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

