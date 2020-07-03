import java.util.Scanner;
public class Sashimi {
    public static String doCase(int sashimi, int nigiri, int budget) {
        for (int i = 0; i <= budget/sashimi; i++) {
            int remaining = budget - i*sashimi;
            if (remaining % nigiri == 0) {
                return "YES";
            }
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int sashimi = input.nextInt();
            int nigiri = input.nextInt();
            int budget = input.nextInt();
            System.out.println(doCase(sashimi, nigiri, budget));
        }
    }
}