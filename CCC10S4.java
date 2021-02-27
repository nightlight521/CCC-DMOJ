import java.util.*;
import java.io.*;

public class CCC10S4 {
    public static class Fence implements Comparable{
        int id;
        int cost;
        Pen one;
        Pen two;

        public Fence(int id, int cost, Pen one) {
            this.id = id;
            this.cost = cost;
            this.one = one;
        }


        public int compareTo(Object o) {
            // this is so bad but contest programming irl lol
            return this.cost - ((Fence)o).cost;
        }
    }

    public static class Pen {
        int id;
        HashSet<Fence> fences;

        public Pen(int id) {
            this.id = id;
            this.fences = new HashSet<Fence>();
        }
    }

    public static int findMST(int m, PriorityQueue<Fence> pq, boolean[] pensAdded, int numAdded) {
        int cost = 0;
        while (numAdded < m) {
            Fence curFence = pq.poll();
            while (pensAdded[curFence.one.id] && pensAdded[curFence.two.id]) {
                curFence = pq.poll();
                if (curFence == null) {
                    return Integer.MAX_VALUE;
                }
            }
            cost += curFence.cost;
            numAdded++;
            if (pensAdded[curFence.one.id]) {
                pensAdded[curFence.two.id] = true;
                for (Fence fence : curFence.two.fences) {
                    pq.add(fence);
                }
                continue;
            }
            pensAdded[curFence.one.id] = true;
            for (Fence fence : curFence.one.fences) {
                pq.add(fence);
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        Pen outside = new Pen(0);
        Pen startPen = new Pen(1);
        HashMap<Integer, Fence> outLinked = new HashMap<>();

        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int m = Integer.parseInt(input[0]);
        for (int i = 0; i < m; i++) {
            input = bin.readLine().trim().split(" ");
            int numFences = Integer.parseInt(input[0]);
            Pen newPen = new Pen(i + 1);
            if (i == 0) {
                startPen = newPen;
            }
            for (int j = 0; j < numFences; j++) {
                int v1 = Integer.parseInt(input[j + 1]);
                int v2 = Integer.parseInt(j == numFences - 1 ? input[1] : input[j + 2]);
                int id = Math.min(v1, v2) * 1000 + Math.max(v1, v2);
                int cost = Integer.parseInt(input[j + 1 + numFences]);
                Fence curFence;
                if (outLinked.containsKey(id)) {
                    curFence = outLinked.get(id);
                    curFence.two = newPen;
                    outLinked.remove(id);
                } else {
                    curFence = new Fence(id, cost, newPen);
                    outLinked.put(id, curFence);
                }
                newPen.fences.add(curFence);
            }
        }
        boolean[] pensAdded = new boolean[m + 1];
        pensAdded[0] = true;
        PriorityQueue<Fence> pq = new PriorityQueue<>();
        for (Fence fence : outLinked.values()) {
            outside.fences.add(fence);
            fence.two = outside;
            pq.add(fence);
        }
        int cost1 = findMST(m, pq, pensAdded, 0);

        pensAdded = new boolean[m + 1];
        pensAdded[0] = true;
        pensAdded[1] = true;
        pq = new PriorityQueue<>();
        for (Fence fence : startPen.fences) {
            pq.add(fence);
        }
        int cost2 = findMST(m, pq, pensAdded, 1);

        System.out.println(Math.min(cost1, cost2));
    }
}