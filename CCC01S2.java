import java.util.Scanner;
import java.lang.Math;

// Spirals
public class CCC01S2 {
  
  static int[] N = {-1, 0};
  static int[] E = {0, 1};
  static int[] W = {0, -1};
  static int[] S = {1, 0};
  
  public static int[] findNextDir(int[] dir) {
    if (dir == S) {
      return E; 
    } else if (dir == E) {
      return N;
    } else if (dir == N) {
      return W;
    } else {
      return S;
    }
  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int start = input.nextInt();
    int end = input.nextInt();
    int numNums = end - start + 1;
    int rows = 0;
    int columns = 0;
    
    while (rows*columns < numNums) {
      rows++;
      if (rows*columns >= numNums) {
        break;
      }
      columns++;
    }
    
    int[][] spiralArr = new int[rows][columns];
    
    int startRow = (int) Math.ceil(rows/2.0-1.0);
    int startColumn = (int) Math.ceil(columns/2.0-1.0);
    spiralArr[startRow][startColumn] = start;
    
    int numStepsInDir = 1;
    int currentStepsInDir = 0;
    int currentSteps = 0;
    int[] currentDir = S;
    int currentRow = startRow;
    int currentColumn = startColumn;
    int currentNum = start;

    for (int i = 1; i < numNums; i++) {
      currentNum++;
      currentRow += currentDir[0];
      currentColumn += currentDir[1];
      spiralArr[currentRow][currentColumn] = currentNum;
      currentStepsInDir++;
      currentSteps++;
      if (currentStepsInDir == numStepsInDir) {
        currentDir = findNextDir(currentDir);
        currentStepsInDir = 0;
      }
      if (currentSteps == 2*numStepsInDir) {
        numStepsInDir++;
        currentSteps = 0;
      }
    }
    
    for (int i = 0; i < spiralArr.length; i++) {
      for (int j = 0; j < spiralArr[0].length; j++) {
        if (spiralArr[i][j] == 0) {
          System.out.print("   ");
        } else {
          System.out.print(spiralArr[i][j]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}