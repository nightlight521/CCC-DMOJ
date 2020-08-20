import java.util.*;
import java.io.*;

class Friends {
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int students = Integer.parseInt(input[0]);
        int[] graph = new int[10000];
        int[] studentCircles = new int[10000];
        int[] studentPos = new int[10000];
        ArrayList<Integer> circleLengths = new ArrayList<>();
        boolean[] visited = new boolean[10000];
        for (int i = 0; i < students; i++) {
            input = bin.readLine().trim().split(" ");
            int student = Integer.parseInt(input[0]);
            int friend = Integer.parseInt(input[1]);
            graph[student] = friend;
        }

        int index = 1;
        int numCircles = 0;
        int currentStudent = 1;
        while (index < 10000) {
            if (!visited[currentStudent]) {
                visited[currentStudent] = true;
                currentStudent = graph[currentStudent];
                continue;
            }
            if (studentCircles[currentStudent] == 0) {
                int curInCircle = currentStudent;
                int count = 0;
                numCircles++;
                do {
                    studentCircles[curInCircle] = numCircles;
                    studentPos[curInCircle] = count;
                    count++;
                    curInCircle = graph[curInCircle];
                } while (curInCircle != currentStudent);
                circleLengths.add(count);
            }
            index++;
            currentStudent = index;
        }

        input = bin.readLine().trim().split(" ");
        int student1 = Integer.parseInt(input[0]);
        int student2 = Integer.parseInt(input[1]);
        while (student1 != 0) {
            int circle = studentCircles[student1];
            if (circle != studentCircles[student2]) {
                System.out.println("No");
            } else {
                int student1Pos = studentPos[student1];
                int student2Pos = studentPos[student2];
                if (student1 >= student2) {
                    System.out.println("Yes " + (circleLengths.get(circle - 1) - 1 - student1Pos + student2Pos));
                } else {
                    System.out.println("Yes " + (student2Pos - student1Pos - 1));
                }
            }
            input = bin.readLine().trim().split(" ");
            student1 = Integer.parseInt(input[0]);
            student2 = Integer.parseInt(input[1]);
        }
    }
}