import java.util.*;
import java.io.*;

public class EscapeRoom {
    public static class Cell {
        int row;
        int column;
        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

      public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(input.readLine().trim());
        int columns = Integer.parseInt(input.readLine().trim());
        int[][] room = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] row = input.readLine().trim().split(" ");
            for (int j = 0; j < columns; j++) {
                room[i][j] = Integer.parseInt(row[j]);
            }
        }

        ArrayList<Cell>[] numbers = new ArrayList[rows*columns + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new ArrayList<Cell>();
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                numbers[i*j].add(new Cell(i-1, j-1));
            }
        }

        ArrayDeque<Cell> toVisit = new ArrayDeque<Cell>();
        toVisit.add(new Cell(0, 0));
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        while (toVisit.size() > 0) {
            Cell current = toVisit.remove();
            if (current.row == rows - 1 && current.column == columns - 1) {
                System.out.println("yes");
                return;
            }
            if (room[current.row][current.column] <= rows*columns) {
                for (Cell cell : numbers[room[current.row][current.column]]) {
                    if (visited[cell.row][cell.column]) continue;
                    visited[cell.row][cell.column] = true;
                    toVisit.add(cell);
                }   
            }
        }
        System.out.println("no");
    }
}