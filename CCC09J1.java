import java.util.Scanner;
class CCC09J1{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num1 = input.nextInt();
    int num2 = input.nextInt();
    int num3 = input.nextInt();
    System.out.print("The 1-3-sum is ");
    System.out.print(num1+num2*3+num3+91);
  }
}