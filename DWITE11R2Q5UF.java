import java.util.*;

public class PortalsUF {
    static class Portal {
        String name;
        Portal parent;
        int depth;
        Portal(String name) {
            this.name = name;
        }
    }
    public static Portal getOrCreatePortal(String name, HashMap<String, Portal> namePortalMap) {
        Portal portal = namePortalMap.get(name);
        if (portal == null) {
            portal = new Portal(name);
            namePortalMap.put(name, portal);
        }
        return portal;
    }
    public static Portal findRoot(Portal portal) {
        if (portal.parent == null) return portal;
        portal.parent = findRoot(portal.parent);
        return portal.parent;
    }
    public static boolean isConnected(Portal place1, Portal place2) {
        return findRoot(place1) == findRoot(place2);
    }
    public static void join(Portal place1, Portal place2) {
        Portal root1 = findRoot(place1);
        Portal root2 = findRoot(place2);
        if (root1 == root2) return;
        Portal newRoot, newChild;
        if (root1.depth > root2.depth) {
            newRoot = root1;
            newChild = root2;
        } else {
            newRoot = root2;
            newChild = root1;
        }
        newChild.parent = newRoot;
        newRoot.depth = Math.max(newRoot.depth, newChild.depth + 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            HashMap<String, Portal> namePortalMap = new HashMap<String, Portal>();
            int inputs = input.nextInt();
            for (int j = 0; j < inputs; j++) {
                String type = input.next();
                String name1 = input.next();
                String name2 = input.next();
                Portal place1 = getOrCreatePortal(name1, namePortalMap);
                Portal place2 = getOrCreatePortal(name2, namePortalMap);
                if (type.equals("p")) {
                    join(place1, place2);
                } else {
                    System.out.println(isConnected(place1, place2) ? "connected" : "not connected");
                }
            }
        }
    }
}

