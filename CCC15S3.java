import java.io.*;
import java.util.*;

class Gates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gates = input.nextInt();
        int planes = input.nextInt();
        int[] gateRanges = new int[planes];
        for (int i = 0; i < planes; i++) {
            gateRanges[i] = input.nextInt();
        }

        TreeSet<Integer> emptyGates = new TreeSet<Integer>();
        for (int i = 1; i <= gates; i++) {
            emptyGates.add(i);
        }
        for (int i = 0; i < planes; i++) {
            if (emptyGates.floor(gateRanges[i]) == null) {
                System.out.println(i);
                return;
            }
            emptyGates.remove(emptyGates.floor(gateRanges[i]));
        }
        System.out.println(planes);
    }
}