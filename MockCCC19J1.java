import java.util.Scanner;
public class Pusheen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cs = input.nextInt();
        int phil = input.nextInt();
        if (cs > phil) {
            System.out.println("CS452");
        } else if (cs < phil) {
            System.out.println("PHIL145");
        }
    }
}