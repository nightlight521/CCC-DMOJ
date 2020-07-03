import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class CCC01S3{
  public static void main(String[] args)throws IOException {
    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(r);
    ArrayList<String> connections = new ArrayList<String>(1);
    do {
      char in = input.read();
      for (int i = 0; i < connections.size(); i++) {
        if (!(connections.get(i).equals(Character.toString(in)))) {
          
        }
      } 
      nodes.add(in);
    } while (in != "**");
  }
}