import java.util.*;
import java.io.*;

public class Music {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));

        String root = bin.readLine().trim();
        String third = bin.readLine().trim();
        String fifth = bin.readLine().trim();

        HashMap<String, Integer> notes = new HashMap<>();
        notes.put("A", 0);
        notes.put("A#", 1);
        notes.put("B", 2);
        notes.put("C", 3);
        notes.put("C#", 4);
        notes.put("D", 5);
        notes.put("D#", 6);
        notes.put("E", 7);
        notes.put("F", 8);
        notes.put("F#", 9);
        notes.put("G", 10);
        notes.put("G#", 11);

        int interval1 = (notes.get(third) - notes.get(root) + 12) % 12;
        int interval2 = (notes.get(fifth) - notes.get(third) + 12) % 12;
        if (interval1 == 4 && interval2 == 4) {
            System.out.println(root);
            System.out.println("augmented");
            System.out.println("root position");
        } else if (interval1 == 4 && interval2 == 3) {
            System.out.println(root);
            System.out.println("major");
            System.out.println("root position");
        } else if (interval1 == 3 && interval2 == 5) {
            System.out.println(fifth);
            System.out.println("major");
            System.out.println("first inversion");
        } else if (interval1 == 5 && interval2 == 4) {
            System.out.println(third);
            System.out.println("major");
            System.out.println("second inversion");
 } else if (interval1 == 3 && interval2 == 4) {
            System.out.println(root);
            System.out.println("minor");
            System.out.println("root position");
        } else if (interval1 == 4 && interval2 == 5) {
            System.out.println(fifth);
            System.out.println("minor");
            System.out.println("first inversion");
        } else if (interval1 == 5 && interval2 == 3) {
            System.out.println(third);
            System.out.println("minor");
            System.out.println("second inversion");
        } else if (interval1 == 3 && interval2 == 3) {
            System.out.println(root);
            System.out.println("diminished");
            System.out.println("root position");
        } else if (interval1 == 3 && interval2 == 6) {
            System.out.println(fifth);
            System.out.println("diminished");
            System.out.println("first inversion");
        } else {
            System.out.println(third);
            System.out.println("diminished");
            System.out.println("second inversion");
        }
    }
}