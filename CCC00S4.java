import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Golf
public class CCC00S4 {
  public static void main(String[] args)throws IOException {
    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(r);
    int distance = Integer.parseInt(input.readLine());
    int num = Integer.parseInt(input.readLine());
    int sum = 0;
    int shortest = 0;
    int[] clubs = new int[num];
    for (int i = 0; i < num; i++) {
      clubs[i] = Integer.parseInt(input.readLine());
    }
    for (int i = 1; i < num+1; i++) {
      for (int j = 0; j < num; j++) {
        sum = clubs[j];
        if (i > 1) {
          for (int k = 1; k < (num-i+2); k++) {
            for (int l = 1; l < i; l++) {
              if ((j+k) < clubs.length) {
                if (i == 3) {
                  System.out.println("hi");
                }
                sum += clubs[j+k];
                System.out.println(sum);
                if ((k+1) % i == 0) {
                  if (i == 3) {
                    System.out.println("hi");
                  }
                  if (sum == distance) {
                    shortest = i;
                    System.out.println("Roberta wins in " + shortest + " strokes.");
                    break;
                  }
                }
               sum = clubs[j];
            }
              }
          }
        } else {
          if (clubs[j] == distance) {
            shortest = 1;
            System.out.println("Roberta wins in 1 strokes.");
            break;
          }
        }
      }
    }
    if (shortest == 0) {
      System.out.println("Roberta acknowledges defeat.");
    }
    input.close();
  }
}

