import java.util.Scanner;

public class Puzzle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gridLength =  input.nextInt();
        int[][] grid = new int[gridLength][gridLength];
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        int size = 0;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                if (grid[i][j] != i*gridLength + j + 1) {
                    size++;
                }
            }
            if (size > 0) {
                break;
            }
        }
        System.out.println(size);
    }
}