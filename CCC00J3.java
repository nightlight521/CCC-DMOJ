import java.util.Scanner;

// Slot Machines
public class CCC00J3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int turns = 0;
        int numQuarters = input.nextInt();
        int timesSincePayed1 = input.nextInt();
        int timesSincePayed2 = input.nextInt();
        int timesSincePayed3 = input.nextInt();
        while (numQuarters > 0) {
            numQuarters--;
            timesSincePayed1++;
            if (timesSincePayed1 == 35) {
                numQuarters += 30;
                timesSincePayed1 = 0;
            }
            turns++;
            if (numQuarters == 0) {
                break;
            }
            numQuarters--;
            timesSincePayed2++;
            if (timesSincePayed2 == 100) {
                numQuarters += 60;
                timesSincePayed2 = 0;
            }
            turns++;
            if (numQuarters == 0) {
                break;
            }
            numQuarters--;
            timesSincePayed3++;
            if (timesSincePayed3 == 10) {
                numQuarters += 9;
                timesSincePayed3 = 0;
            }
            turns++;
            if (numQuarters == 0) {
                break;
            }
        }
        System.out.println("Martha plays " + turns + " times before going broke.");
    }
}