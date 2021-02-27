import java.util.*;
import java.io.*;

public class LiteratureClub {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        input = bin.readLine().trim().split(" ");
        int w = Integer.parseInt(input[0]);
        HashMap<Integer, String> names = new HashMap<>();
        names.put(0, "Sayori");
        names.put(1, "Natsuki");
        names.put(2, "Yuri");
        names.put(3, "Monika");
        HashSet<String>[] triggers = new HashSet[4];
        for (int i = 0; i < 4; i++) {
            triggers[i] = new HashSet<String>();
            input = bin.readLine().trim().split(" ");
            for (String word : input) {
                triggers[i].add(word);
            }
        }
        HashSet<String> found = new HashSet<>();
        int[] points = new int[4];
        for (int i = 0; i < n; i++) {
            input = bin.readLine().trim().split(" ");
            for (String word : input) {
                for (int j = 0; j < 4; j++) {
                    if (!triggers[j].contains(word) || found.contains(word)) continue; 
                    points[j]++;
                }
                found.add(word);
            }
        }
        ArrayList<String> answers = new ArrayList<>();
        int max = 0;
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += points[i];
            if (points[i] < max || points[i] == 0) continue;
            if (points[i] > max) {
                max = points[i];
                answers.clear();
            }
            answers.add(names.get(i));
        }
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}