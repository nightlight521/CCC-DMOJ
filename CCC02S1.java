import java.util.*;
import java.io.*;

public class CCC02S1 {
    static int totalCombos;
    static int minTickets = Integer.MAX_VALUE;
    static ArrayList<int[]> allCombos = new ArrayList<>();
    static boolean isComboFound(int[] thisCombo) {
        for (int i = 0; i < allCombos.size(); i++) {
            int[] curCombo = allCombos.get(i);
            int similarities = 0;
            for (int j = 0; j < 4; j++) {
                if (curCombo[j] == thisCombo[j]) {
                    similarities++;
                }
            }
            if (similarities == 4) return true;
        }
        return false;
    }

    static void findAllCombinations(int needed, int[] colours, int[] combo) {
        if (needed == 0 && !isComboFound(combo)) {
            allCombos.add(combo.clone());
            minTickets = Math.min(minTickets, combo[0] + combo[1] + combo[2] + combo[3]);
            totalCombos++;
            System.out.println("# of PINK is " + combo[0] + " " +
                               "# of GREEN is "  + combo[1] + " " +
                               "# of RED is " + combo[2] + " " +
                               "# of ORANGE is " + combo[3]);
            return;
        } else if (needed < 0 || needed == 0 && isComboFound(combo)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            combo[i]++;
            int ogNeeded = needed;
            findAllCombinations(needed - colours[i], colours, combo);
            needed = ogNeeded;
            combo[i]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] colours = new int[4];
        for (int i = 0; i < 4; i++) {
            colours[i] = Integer.parseInt(bin.readLine().trim());
        }
        int needed = Integer.parseInt(bin.readLine().trim());

        findAllCombinations(needed, colours, new int[4]);
        System.out.println("Total combinations is " + totalCombos + ".");
        System.out.println("Minimum number of tickets to print is " + minTickets + ".");
    }
}
