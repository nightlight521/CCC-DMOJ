import java.util.Scanner;

public class DMPG15B3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int width = input.nextInt();
        int height = input.nextInt();
        char[][] bush = new char[height][width];
        char[] line = input.nextLine().toCharArray();
        for (int i = 0; i < height; i++) {
          line = input.nextLine().toCharArray();
          for (int j = 0; j < line.length; j++) {
            bush[i][j] = line[j];
          }
        }
        
        String edible = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < bush[i].length; j++) {
                if (bush[i][j] == '*') {
                    bush[i][j] = ' ';
                } else if (bush[i][j] == 'o') {
                    edible += "o";
                    bush[i][j] = ' ';
                }
                System.out.print(bush[i][j]);
            }
            System.out.println();
        }
        System.out.println(edible);
    }
}