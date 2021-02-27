import java.io.*;
import java.util.*;

public class Transport {
    public static class Line {
        int num;
        ArrayList<Line> escalators;

        public Line(int num) {
            this.num = num;
            this.escalators = new ArrayList<Line>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int l = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        int n = Integer.parseInt(input[3]);
        Line[] lines = new Line[l + 1];

        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            int line = Integer.parseInt(input[0]);
            int connection = Integer.parseInt(input[1]);
            if (lines[line] == null) {
                lines[line] = new Line(line);
            }
            if (lines[connection] == null) {
                lines[connection] = new Line(connection);
            }
            lines[line].escalators.add(lines[connection]);
        }

        ArrayDeque<Line> toVisit = new ArrayDeque<>();
        boolean[] visited = new boolean[l + 1];
        visited[b] = true;
        int steps = 1;
        ArrayDeque<Integer> parents = new ArrayDeque<>();
        int curParent = 0;
        int parentNum = 0;
for (Line connected : lines[b].escalators) {
            parents.add(0);
            visited[connected.num] = true;
            toVisit.add(connected);
        }
        parentNum++;
        while (toVisit.size() > 0) {
            Line cur = toVisit.remove();
            int newParent = parents.poll();
            //System.out.println(cur.num + " " + newParent + " " + curParent + " " + parentNum);
            if (newParent != curParent) {
                parentNum++;
                steps++;
                curParent = newParent;
            }
            if (cur.num == p) {
                System.out.println(steps);
                return;
            }
            for (Line connected : cur.escalators) {
                if (visited[connected.num]) continue;
                parents.add(parentNum);
                visited[connected.num] = true;
                toVisit.add(connected);
            }
        }
    }
}