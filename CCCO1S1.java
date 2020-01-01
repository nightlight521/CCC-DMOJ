import java.util.Scanner;

// Keeping Score
public class CCCO1S1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String cards = input.nextLine();
    int[] points = new int[4];
    char[][] suitCards = new char[4][17];
    int[] numCards = new int[4];
    int currentSuit = 0;
    
    System.out.println("Cards Dealt     Points");
    for (int i = 0; i < cards.length(); i++) {
      switch (cards.charAt(i)) {
        case 'H':
          currentSuit = 0;
          break;
        case 'D':
          currentSuit = 1;
          break;
        case 'S':
          currentSuit = 2;
          break;
        case 'C':
          currentSuit = 3;
          break;
        case 'K':
          points[currentSuit] += 3;
          suitCards[currentSuit][i] = 'K';
          numCards[currentSuit] += 1;
          break;
        case 'Q':
          points[currentSuit] += 2;
          suitCards[currentSuit][i] = 'Q';
          numCards[currentSuit] += 1;
          break;
        case 'J':
          points[currentSuit] += 1;
          suitCards[currentSuit][i] = 'J';
          numCards[currentSuit] += 1;
          break;
        case 'A':
          points[currentSuit] += 4;
          suitCards[currentSuit][i] = 'A';
          numCards[currentSuit] += 1;
          break;
        default: 
          suitCards[currentSuit][i] = cards.charAt(i);
          numCards[currentSuit] += 1;
      }
    }
    
    for (int i = 0; i < 4; i++) {
      if (numCards[i] == 2) {
        points[i] += 1;
      } else if (numCards[i] == 1) {
        points[i] += 2;
      } else if (numCards[i] == 0) {
        points[i] += 3;
      }
    }

    System.out.print("Clubs ");
    for (int i = 0; i < 17; i++) {
      if (suitCards[3][i] != '\u0000') {
        System.out.print(suitCards[3][i] + " ");
      } 
    }
    System.out.println(points[3]);
    System.out.print("Diamonds ");
    for (int i = 0; i < 17; i++) {
      if (suitCards[1][i] != '\u0000') {
        System.out.print(suitCards[1][i] + " ");
      } 
    }
    System.out.println(points[1]);
    System.out.print("Hearts ");
    for (int i = 0; i < 17; i++) {
      if (suitCards[0][i] != '\u0000') {
        System.out.print(suitCards[0][i] + " ");
      } 
    }
    System.out.println(points[0]);
    System.out.print("Spades ");
    for (int i = 0; i < 17; i++) {
      if (suitCards[2][i] != '\u0000') {
        System.out.print(suitCards[2][i] + " ");
      } 
    }
    System.out.println(points[2]);
    System.out.println("Total " + (points[0] + points[1] + points[2] + points[3]));
  }
}