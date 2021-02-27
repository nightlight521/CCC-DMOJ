import java.util.*;
import java.io.*;

public class Alucard {

    static class Room {
        int id;
        // only from parent to this room
        int cost = 0;
        boolean visited = false;
        Room parent = null;
        // maps children to cost of passageways
        HashMap<Room, Integer> children = new HashMap<>();

        public Room(int id) {
            this.id = id;
        }

        public int hashCode() {
            return id;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Room)) {
                return false;
            }

            Room r = (Room) o;
            return (r.id == this.id);
        }
    }

    static class Pair {
        Room room1;
        Room room2;

        public Pair(Room room1, Room room2) {
            this.room1 = room1;
            this.room2 = room2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // set up a tree with all the rooms
        Room[] rooms = new Room[n + 1];
        Room root = new Room(1);
        rooms[1] = root;
        for (int i = 0; i < n - 1; i++) {
            input = bin.readLine().trim().split(" ");
            int id1 = Integer.parseInt(input[0]);
            int id2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            Room room1, room2;
            if (rooms[id2] == null) {
                room2 = new Room(id2);
                rooms[id2] = room2;
            } else {
                room2 = rooms[id2];
            }
            if (rooms[id1] == null) {
                room1 = new Room(id1);
                rooms[id1] = room1;
            } else {
                room1 = rooms[id1];
            }
            room1.children.put(room2, cost);
            room2.children.put(room1, cost);
        }

        // BFS through the tree to determine what's parent and what's not.
        // honestly i'm starting to think my solution may be kinda scuffed but oh well
        // also visiting things more than once isn't an issue bc each room
        // only has one parent
        ArrayDeque<Pair> toVisit = new ArrayDeque<>();
        for (Room child : root.children.keySet()) {
            toVisit.add(new Pair(child, root));
        }
        while (!toVisit.isEmpty()) {
            Pair pair = toVisit.poll();
            Room cur = pair.room1;
            cur.parent = pair.room2;
            cur.cost = cur.children.get(cur.parent);
            cur.children.remove(cur.parent);
            for (Room child : cur.children.keySet()) {
                toVisit.add(new Pair(child, cur));
            }
        }

        // Finally, process the queries, marking all ancestors as visited
        // when visiting a room
        int minCost = 0;
        for (int i = 0; i < k; i++) {
            int id = Integer.parseInt(bin.readLine().trim());
            Room room = rooms[id];
            if (room.visited) continue;
            int old = minCost;
            Room curAncestor = room.parent;
            while (curAncestor != null && !curAncestor.visited) {
                curAncestor.visited = true;
                minCost += curAncestor.cost;
                curAncestor = curAncestor.parent;
            }
            minCost += room.cost;
            room.visited = true;
        }
        System.out.println(minCost);
    }
}