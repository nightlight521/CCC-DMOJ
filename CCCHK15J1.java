import java.util.Scanner;
class CCCHK15J1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numGames = input.nextInt();
    input.nextLine();
    String alice = input.nextLine();
    String bob = input.nextLine();
    String aliceInstance, bobInstance;
    int bobWon = 0;
    int aliceWon = 0;
    for (int i = 0; i < numGames; i++) {
      if (i < numGames-1) {
        aliceInstance = alice.substring(0, alice.indexOf(" "));
        bobInstance = bob.substring(0, bob.indexOf(" "));
        bob = bob.substring(bob.indexOf(" ")+1);
        alice = alice.substring(alice.indexOf(" ")+1);
      } else {
        aliceInstance = alice.substring(0);
        bobInstance = bob.substring(0);
      }
      if (bobInstance.equals("rock")) {
        if (aliceInstance.equals("paper")) {
          aliceWon++;
        } else if (aliceInstance.equals("scissors")) {
          bobWon++;
        }
      } else if (bobInstance.equals("scissors")) {
        if (aliceInstance.equals("paper")) {
          bobWon++;
        } else if (aliceInstance.equals("rock")) {
          aliceWon++;
        }
      } else {
        if (aliceInstance.equals("scissors")) {
          aliceWon++; 
        } else if (aliceInstance.equals("rock")) {
          bobWon++;
        }
      }
    }
    System.out.print(aliceWon);
    System.out.print(" ");
    System.out.print(bobWon);
  }
}