import java.util.Scanner;
import java.lang.Math;

// Spirals Exact
public class CCC01S2E {
  
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
    int numTestCases = input.nextInt();
    
    for (int i = 0; i < numTestCases; i++) {
      int start = input.nextInt();
      int end = input.nextInt();
      int spaces;
      if (end < 10) {
        spaces = 2;
      } else {
        spaces = 3;
      }
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
      
      for (int j = 1; j < numNums; j++) {
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
      
      for (int j = 0; j < spiralArr.length; j++) {
        for (int k = 0; k < spiralArr[0].length; k++) {
          boolean hasTens = false;
          String line = ""; 
          for (int l = 0; l < spiralArr.length; l++) {
            if (spiralArr[l][k] > 9) {
              hasTens = true;
              break;
            }
          }
          if (spiralArr[j][k] == 0) {
            if (hasTens) {
              if (k == spiralArr[0].length-1) {
                line += "  ";
              } else {
                line += "   ";
              }
            } else {
              if (k == spiralArr[0].length-1) {
                line += " ";
              } else {
                line += "  ";
              }
            }
          } else if (spiralArr[j][k] < 10 && hasTens) {
            if (k != spiralArr[0].length-1) {
              line += " " + spiralArr[j][k] + " ";
            } else {
              line += " " + spiralArr[j][k];
            }
          } else if (k == spiralArr[0].length-1) {
            line += spiralArr[j][k];
          } else {
            line += spiralArr[j][k] + " ";
          }
          line.trim();
          System.out.print(line);
        }
        System.out.println();
      }
      if (i < numTestCases - 1) { 
        System.out.println();
      }
    }
  }
}