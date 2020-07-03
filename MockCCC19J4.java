import java.util.*;

public class NekoAtsume {
  static class FoodOrder implements Comparable<FoodOrder> {
    int numOrders;
    int nameIndex;
    
    public FoodOrder(int numOrders, int nameIndex) {
        this.numOrders = numOrders;
        this.nameIndex = nameIndex;
    }
    
    public int compareTo(FoodOrder order) {
        if (this.numOrders > order.numOrders) {
            return -1;
        } else if (this.numOrders < order.numOrders) {
            return 1;
        } else if (this.nameIndex < order.nameIndex) {
            return -1;
        }
        return 1;
    }
  }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOrders =  input.nextInt();
        String[] names = {"Deluxe Tuna Bitz", "Bonito Bitz", "Sashimi", "Ritzy Bitz"};
        ArrayList<FoodOrder> orders = new ArrayList<FoodOrder>();
        for (int i = 0; i < names.length; i++) {
            orders.add(new FoodOrder(0, i));
        }
        for (int i = 0; i < numOrders + 1; i++) {
            String nextOrder = input.nextLine();
            for (int j = 0; j < names.length; j++) {
                if (!nextOrder.equals(names[j])) continue;
                orders.get(j).numOrders++;                
            }
        }
        input.close();
        
        Collections.sort(orders);
        
        for (FoodOrder order : orders) {
          if (order.numOrders <= 0) continue;
          System.out.println(names[order.nameIndex] + " " + order.numOrders);
        }   
    }
}
