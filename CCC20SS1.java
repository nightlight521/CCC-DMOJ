import java.util.Scanner;
import java.lang.Math;

//CCC20S1
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int[] times = new int[num];
    int[] distances = new int[num];
    double maxSpeed = 0;
    double timeDiff = 0;
    double distDiff = 0;
    double currentMax = 0;
    for (int i = 0; i < num; i++) {
      int nextTime = input.nextInt();
      int nextDist = input.nextInt();
      if (i == 0) {
        times[i] = nextTime;
        distances[i] = nextDist;
      } else {
        if (times[i-1] > nextTime) {
          times[i] = times[i-1];
          times[i-1] = nextTime;
          distances[i] = distances[i-1];
          distances[i-1] = nextDist;
        } else {
          times[i] = nextTime;
          distances[i] = nextDist;
        }
      }
    }
    for (int i = 0; i < num-1; i++) {
      timeDiff = Math.abs(times[i] - times[i+1]);
      distDiff = Math.abs(distances[i] - distances[i+1]);
      currentMax = distDiff/timeDiff;
      if (i == 0) {
        maxSpeed = currentMax;
      } else if (currentMax > maxSpeed) {
          maxSpeed = currentMax;
      }
    }
    System.out.println(maxSpeed);
    input.close();
  }
}