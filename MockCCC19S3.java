import java.util.*;
import java.lang.Math;

public class PusheenS3BFS {
    static int[][] DIRS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1},
        {0, 0}
    };
    static boolean isValidMove(int curX, int curY, int nextX, int nextY, int[][] windPos) {
        if (nextX < 0 || nextY < 0 || nextX >= windPos.length || nextY >= windPos[0].length || windPos[nextX][nextY] == 1) {
            return false;
        }
        if (curX == nextX && curY == nextY) {
            return true;
        }
        if (curX == nextX) {
            int stepY = curY < nextY ? 1 : -1;
            for (int y = curY; y != nextY; y+=stepY) {
                if (windPos[curX][y] == 1) return false;
            }
            return true;
        }
        int stepX = curX < nextX ? 1 : -1;
        int dX = nextX - curX;
        int dY = nextY - curY;
        for (int x = curX; x != nextX; x+= stepX) {
            if (dY * (x - curX) % dX != 0) continue;
            int y = dY * (x - curX) / dX + curY;
            if (windPos[x][y] == 1) return false;
        }
        return true;
    }

    public static class State {
        int x, y, vX, vY, time;
        public State(int x, int y, int vX, int vY, int time) {
            this.x = x;
            this.y = y;
            this.vX = vX;
            this.vY = vY;
            this.time = time;
        }
    }

    static int bfs(int startX, int startY, int sushiX, int sushiY, int[][] windPos, int[][][][] curMap) {
        int maxVX = (curMap[0][0].length - 1)/2;
        int maxVY = (curMap[0][0][0].length - 1)/2;
        ArrayDeque<State> queue = new ArrayDeque<State>();
        queue.add(new State(startX, startY, 0, 0, 0));
        while (queue.size() > 0) {
            State state = queue.poll();
            if (state.x == sushiX && state.y == sushiY && state.vX == 0 && state.vY == 0) {
                return state.time;
            }
            for (int i = 0; i < DIRS.length; i++) {
                int[] dir = DIRS[i];
                int nextVX = state.vX + dir[0];
                int nextVY = state.vY + dir[1];
                int nextX = state.x + nextVX;
                int nextY = state.y + nextVY;
                if (!isValidMove(state.x, state.y, nextX, nextY, windPos)) continue;
                if (Math.abs(nextVX) > maxVX || Math.abs(nextVY) > maxVY) continue;
                if (curMap[nextX][nextY][nextVX + maxVX][nextVY + maxVY] == 1) continue;
                queue.add(new State(nextX, nextY, nextVX, nextVY, state.time + 1));
                curMap[nextX][nextY][nextVX + maxVX][nextVY + maxVY] = 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxX = input.nextInt();
        int maxY = input.nextInt();
        int windNum = input.nextInt();
        int startX = input.nextInt();
        int startY = input.nextInt();
        int sushiX = input.nextInt();
        int sushiY = input.nextInt();
        int[][] windPos = new int[maxX+1][maxY+1];
        for (int i = 0; i < windNum; i++) {
            int windX = input.nextInt();
            int windY = input.nextInt();
            windPos[windX][windY] = 1;
        }
        int[][][][] curMap = new int[maxX+1][maxY+1][2*((int) Math.sqrt(maxX)) + 1][2*((int) Math.sqrt(maxY)) + 1];
        System.out.println(bfs(startX, startY, sushiX, sushiY, windPos, curMap));
    }
}