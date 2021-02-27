import java.util.*;
import java.io.*;

public class Salesmen {

    static class City {
        int id;
        HashSet<Integer> connections;

        public City(int id, HashSet<Integer> connections) {
            this.id = id;
            this.connections = connections;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int m = Integer.parseInt(input[1]);
        HashMap<Integer, City> cities = new HashMap<>();
        for (int i = 0; i < m; i++) {
            input = bin.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            City cityA, cityB;
            if (!cities.containsKey(a)) {
                cityA = new City(a, new HashSet<Integer>());
                cities.put(a, cityA);
            } else {
                cityA = cities.get(a);
            }
            if (!cities.containsKey(b)) {
                cityB = new City(b, new HashSet<Integer>());
                cities.put(b, cityB);
            } else {
                cityB = cities.get(b);
            }
            cityA.connections.add(b);
            cityB.connections.add(a);
        }

        HashSet<Integer> visited = new HashSet<>();

        input = bin.readLine().trim().split(" ");
        int k = Integer.parseInt(input[0]);
        ArrayDeque<City>[] diffPaths = new ArrayDeque[k];
        for (int i = 0; i < k; i++) {
            int city = Integer.parseInt(bin.readLine().trim());
            diffPaths[i] = new ArrayDeque<City>();
            diffPaths[i].add(cities.get(city));
            visited.add(city);
        }

        int steps = 0;
        int numEmpty = 0;
        while (true) {
            for (ArrayDeque<City> path : diffPaths) {
                if (path.isEmpty()) continue;
                int size = path.size();
                for (int i = 0; i < size; i++) {
                    City city = path.poll();
                    for (int connection : city.connections) {
                        City connectedCity = cities.get(connection);
                        if (visited.contains(connection)) continue;
                        path.add(connectedCity);
                        visited.add(connection);
                    }
                }
                if (path.isEmpty()) {
                    numEmpty++;
                    if (numEmpty == k) {
                        System.out.println(steps);
                        return;
                    }
                }
            }
            steps++;
        }
    }
}