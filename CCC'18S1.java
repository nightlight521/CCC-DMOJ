import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class VoronoiVillages {
  
  public static void main(String[] args) {
    
    double min, tempMin;
    Scanner input = new Scanner(System.in);
    int numVillages = input.nextInt();
    double[] villages = new double[numVillages];
    for (int i = 0; i < numVillages; i++) {
      villages[i] = input.nextInt();
    }
    Arrays.sort(villages);
    
    min = 2000000000;
    for (int i = 1; i < villages.length-1; i++) {
      tempMin = (villages[i]-villages[i-1])/2.0 + (villages[i+1]-villages[i])/2.0;
      if (tempMin < min) {
        min = tempMin;
      }
    }
    System.out.printf("%.1f", min);
  }
}