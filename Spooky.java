import java.util.*;
import java.io.*;

public class Spooky {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);

        int[] spookies = new int[n + 1];
        HashSet<Integer> startStops = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> spookHouses = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            input = bin.readLine().trim().split(" ");
            int startHouse = Integer.parseInt(input[0]);
            int endHouse = Integer.parseInt(input[1]);
            if (!spookHouses.containsKey(startHouse)) {
                spookHouses.put(startHouse, new ArrayList<Integer>());
            }
            if (!spookHouses.containsKey(endHouse)) {
                spookHouses.put(endHouse, new ArrayList<Integer>());
            }
            startStops.add(startHouse);
            startStops.add(endHouse);
            spookHouses.get(startHouse).add(i);
            spookHouses.get(endHouse).add(i);
            spookies[i] = Integer.parseInt(input[2]);
        }
        ArrayList<Integer> sortedStartStops = new ArrayList<>(startStops);
        Collections.sort(sortedStartStops);

        HashSet<Integer> active = new HashSet<>();
        long curSpook = 0;
        int candy = 0;
        int lastStop = 0;
        boolean lastHouseReached = false;
        for (int stop : sortedStartStops) {
            if (stop == l) {
                lastHouseReached = true;
            }
           // System.out.println("stop: " + stop);
            // System.out.println("init candy: " + candy + " init spook: " + curSpook);
            if (curSpook < s) {
                candy += stop - (lastStop + 1);
            }
            //System.out.println("after init add: " + candy);
            ArrayList<Integer> houseList = spookHouses.get(stop);
            long newSpook = curSpook;
            for (int spook : houseList) {
                if (active.contains(spook)) {
                    newSpook -= spookies[spook];
                    active.remove(spook);
              //      System.out.println("next spook: " + newSpook);
                } else {
                    newSpook += spookies[spook];
                    active.add(spook);
                    curSpook += spookies[spook];
             //       System.out.println("new spook: " + curSpook);
                }
            }
            if (curSpook < s) {
                candy++;
            //    System.out.println("added cur: " + candy);
            }
            curSpook = newSpook;
            lastStop = stop;
        }
        if (!lastHouseReached) {
            candy += l - lastStop;
        }

        System.out.println(candy);
    }
}