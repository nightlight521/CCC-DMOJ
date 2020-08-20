import java.util.*;
import java.io.*;

class Waterpark {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] pathsToNode = new int[n + 1];
        ArrayList<Integer>[] parentsOfNode = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parentsOfNode[i] = new ArrayList<Integer>();
        }
        input = bin.readLine().trim().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        while (x != 0) {
            parentsOfNode[y].add(x);
            input = bin.readLine().trim().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
        }
        pathsToNode[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int pathsToI = 0;
            for (int parent : parentsOfNode[i]) {
                pathsToI += pathsToNode[parent];
            }
            pathsToNode[i] = pathsToI;
        }
        System.out.println(pathsToNode[n]);
    }
}