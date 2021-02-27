import java.util.*;
import java.io.*;

public class Finder {
    static int[][] dirs = {{0, -1},
                           {1, -1},
                           {1, 0},
                           {1, 1},
                           {0, 1},
                           {-1, 1},
                           {-1, 0},
                           {-1, -1}};
    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Point)) {
                return false;
            }

            Point p = (Point) o;

            return (p.x == this.x && p.y == this.y);
        }

        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        HashSet<Point> blocks = new HashSet<>();
        ArrayList<Point> startBlocks = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            input = bin.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Point block = new Point(x, y);
            blocks.add(block);
            if (x != 1 && y != m) continue;
            startBlocks.add(block);
        }

        for (int i = startBlocks.size() - 1; i >= 0; i--) {
            ArrayDeque<Point> toVisit = new ArrayDeque<>();
            Point start = startBlocks.get(i);
            if (!blocks.contains(start)) continue;
            toVisit.add(start);
            blocks.remove(start);
while (toVisit.size() > 0) {
                Point cur = toVisit.remove();
                for (int[] dir : dirs) {
                    Point adj = new Point(cur.x + dir[0], cur.y + dir[1]);
                    if (!blocks.contains(adj)) continue;
                    if (adj.x == n || adj.y == 1) {
                        System.out.println("NO");
                        return;
                    }
                    toVisit.add(adj);
                    blocks.remove(adj);
                }
            }
        }
        System.out.println("YES");
    }
}