import java.util.*;
import java.io.*;

public class Spavanac {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int hours = Integer.parseInt(input[0]);
        int minutes = Integer.parseInt(input[1]);
        int timeLeft = 45;
        int minutesSubtracted = Math.min(minutes, timeLeft);
        minutes -= minutesSubtracted;
        timeLeft -= minutesSubtracted;
        if (timeLeft > 0) {
            hours = hours == 0 ? 23 : hours - 1;
            minutes = 60 - timeLeft;
        }
        System.out.println(hours + " " + minutes);

    }
}