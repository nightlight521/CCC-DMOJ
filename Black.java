import java.util.*;
import java.io.*;

public class Black {
    public static class Node {
        boolean colour; // black = true, pink = false
        ArrayList<Node> connections;
        int num;

        public Node(boolean colour, int num) {
            this.colour = colour;
            this.num = num;
            this.connections = new ArrayList<Node>();
        }
    }

    static ArrayList<Integer> walk = new ArrayList<>();

    static void addAncestors(ArrayDeque<Node> ancestors) {
        ArrayList<Integer> toAdd = new ArrayList<>();
        Iterator<Node> itr = ancestors.descendingIterator();
        while (itr.hasNext()) {
            Node nextNode = itr.next();
            if (nextNode.num == walk.get(walk.size() - 1)) break;
            nextNode.colour = !nextNode.colour;
            toAdd.add(nextNode.num);
        }
        for (int i = toAdd.size() - 1; i >= 0; i--) {
            walk.add(toAdd.get(i));
        }
    }

    static boolean addToWalk(Node curNode, ArrayDeque<Node> ancestors) {
        ArrayList<Node> connected = curNode.connections;

        if (!ancestors.isEmpty() && connected.size() == 1 && ancestors.getLast().num == connected.get(0).num) {
            //System.out.println("leaf:" + curNode.num);
            if (curNode.colour) {
                return false;
            }
            curNode.colour = true;
            addAncestors(ancestors);
            walk.add(curNode.num);
 return true;
        }

        boolean addedAny = false;
        for (Node neighbour : connected) {
            if (!ancestors.isEmpty() && neighbour == ancestors.getLast()) {
                continue;
            }
            ancestors.add(curNode);
            if (addToWalk(neighbour, ancestors)) {
                addedAny = true;
                curNode.colour = !curNode.colour;
                walk.add(curNode.num);
            }
            ancestors.removeLast();
        }

 //     System.out.println(curNode.num + " " + curNode.colour);
 //     for (int i = 0; i < walk.size(); i++) {
 //         System.out.print(walk.get(i));
 //     }
        //System.out.println();
        if (curNode.colour) return addedAny;
        if (!addedAny) {
            if (curNode.num == 1) {
                walk.add(connected.get(0).num);
                walk.add(curNode.num);
                walk.add(connected.get(0).num);
                return true;
            }
            addAncestors(ancestors);
            curNode.colour = !curNode.colour;
            walk.add(curNode.num);
            return true;
        }
        if (curNode.num == 1) {
            walk.remove(walk.size() - 1);
            return true;
        }
        Node parent = ancestors.getLast();
        walk.add(parent.num);
        parent.colour = !parent.colour;
        walk.add(curNode.num);
return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine().trim());
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            boolean colour = Integer.parseInt(bin.readLine().trim()) == 1 ? true : false;
            nodes[i + 1] = new Node(colour, i + 1);
        }
        String[] input;
        for (int i = 0; i < n - 1; i++) {
            input = bin.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            nodes[a].connections.add(nodes[b]);
            nodes[b].connections.add(nodes[a]);
        }

        walk.add(1);
        ArrayDeque<Node> ancestors = new ArrayDeque<>();
        addToWalk(nodes[1], ancestors);
        for (int i = 0; i < walk.size(); i++) {
            System.out.print(walk.get(i) + " ");
        }
        System.out.println();
    }
}