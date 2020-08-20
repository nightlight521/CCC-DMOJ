import java.util.*;
import java.io.*;

class MusicalChairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] chairs = new int[n];
        int emptyChairs = k;
        input = bin.readLine().trim().split(" ");
        for (int i = 0; i < input.length; i++) {
            chairs[Integer.parseInt(input[i]) - 1] = -1;
        }
        input = bin.readLine().trim().split(" ");
        int startIndex = 1000000;
        for (int i = 0; i < input.length; i++) {
            int startChair = Integer.parseInt(input[i]) - 1;
            if (chairs[startChair] == -1) {
                chairs[startChair] = -3;
            } else {
                chairs[startChair] = i + 1;
            }
            startIndex = Math.min(startIndex, startChair);
        }
        int index = startIndex;
        Stack<Integer> studentsProcessing = new Stack<>();
        while (emptyChairs > 0 || studentsProcessing.empty()) {
            if (chairs[index] > 0) {
                studentsProcessing.push(chairs[index]);
                chairs[index] = 0;
            } else if (chairs[index] == -1 && !studentsProcessing.empty()) {
                chairs[index] = -2;
                emptyChairs--;
                studentsProcessing.pop();
            } else if (chairs[index] == -3) {
                chairs[index] = -2;
                emptyChairs--;
            }
            index = index == n - 1 ? 0 : index + 1;
        }
        System.out.println(studentsProcessing.pop());
    }
}
