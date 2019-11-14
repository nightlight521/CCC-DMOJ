import java.util.Scanner;

class DMOJBinary{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int numDecimal = input.nextInt();
    String binary = "";
    int largest;
    //1 2 4 8  16 32 64 128  256 512 1024 2048
    for (int i = 0; i < numDecimal; i++) {
      int decimal = input.nextInt();
      while (decimal-largest < 0
      
    }
    int decimal = input.nextInt();
    for (int i = 7; i > -1; i--) {
      if (decimal - Math.pow(2, i) >= 0) {
        binary += "1";
        decimal -= Math.pow(2, i);
      } else {
        binary += "0";
      }
    }
    System.out.println(binary);
  }
}