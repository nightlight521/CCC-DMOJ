import java.util.*;

public class AbsolutelyAcidic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sensors = input.nextInt();
        int[] frequencies = new int[1001];
        for (int i = 0 ; i < sensors; i++) {
            int reading = input.nextInt();
            frequencies[reading] += 1;
        }

        int maxF = 0;
        int maxF2 = 0;
        int maxFMaxReading = 0;
        int maxFMinReading = 0;
        int maxF2MaxReading = 0;
        int maxF2MinReading = 0;

        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > maxF) {
                maxF2 = maxF;
                maxF2MaxReading = maxFMaxReading;
                maxF2MinReading = maxFMinReading;
                maxF = frequencies[i];
                maxFMaxReading = i;
                maxFMinReading = i;
            } else if (frequencies[i] == maxF) {
                if (i > maxFMaxReading) {
                    maxFMaxReading = i;
                } else if (i < maxFMinReading) {
                    maxFMinReading = i;
                }
            } else if (frequencies[i] > maxF2) {
                maxF2 = frequencies[i];
                maxF2MaxReading = i;
                maxF2MinReading = i;
            } else if (frequencies[i] == maxF2) {
                if (i > maxF2MaxReading) {
                    maxF2MaxReading = i;
                } else if (i < maxF2MinReading) {
                    maxF2MinReading = i;
                }
            }
        }

        if (maxFMaxReading != maxFMinReading) {
            System.out.println(Math.abs(maxFMaxReading - maxFMinReading));
        } else if (maxF2MaxReading == maxF2MinReading) {
            System.out.println(Math.abs(maxFMaxReading - maxF2MaxReading));
        } else {
            System.out.println(Math.max(Math.abs(maxFMaxReading - maxF2MaxReading), Math.abs(maxFMaxReading - maxF2MinReading)));
        }
    }
}
