import java.util.*;

class Portals {
    static class Portal {
        String name;
        ArrayList<Portal> connections = new ArrayList<Portal>();
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
    public static boolean isConnected(Portal place1, Portal place2) {
        Queue<Portal> places = new ArrayDeque<Portal>();
        Set<String> visited = new HashSet<String>();
        places.add(place1);
        visited.add(place1.name);
        while (places.size() > 0) {
            Portal currentPlace = places.remove();
            if (currentPlace == place2) return true;
            for (Portal portal : currentPlace.connections) {
                if (visited.contains(portal.name)) continue;
                places.add(portal);
                visited.add(portal.name);
            }
        }
        return false;
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
                    place1.connections.add(place2);
                    place2.connections.add(place1);
                } else {
                    System.out.println(isConnected(place1, place2) ? "connected" : "not connected");
                }
            }
        }
    }
}
