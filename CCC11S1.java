import java.util.Scanner;

// English or French
public class CCC11S1 { 
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int numLines = input.nextInt();
    int numS = 0;
    int numT = 0;
    input.nextLine();
    for (int i = 0; i < numLines; i++) {
      String line = input.nextLine();
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == 's' || line.charAt(j) == 'S') {
          numS++;
        } else if (line.charAt(j) == 'T' || line.charAt(j) == 't') {
          numT++;
        }
      }
    }
    if (numT > numS) {
      System.out.println("English");
    } else {
      System.out.println("French");
    }
  }
}