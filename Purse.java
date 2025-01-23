import java.util.HashMap;
import java.util.Map;

public class Purse {

    private Map<Denomination, Integer> cash = new HashMap<> ();

    public void add(Denomination type, int num) {
        cash.put (type, num);
    }

    public double remove(Denomination type, int num) {
        // Subtract num from the key to find the remaining number of Denominations
       int val = cash.get(type) - num;
       // Replace with the new number of Denominations
       cash.remove(type, num);
       cash.put (type, val);

       // Find the amount of money removed
       double total = 0;
       for(int i = 0; i < num; i++) {
          total += type.amt();
       }
       return total;
    }

   public double getValue() {
        double total = 0;

        //Move through the map
        for(Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            //Repeat for the number of a single denomination
            for(int i = 0; i < entry.getValue(); i++) {
                //Add the amount to the total(could probably use multiplication
                total += entry.getKey().amt();
            }
        }
        return total;
   }

   public String toString() {
        String out = Double.toString(this.getValue());
        return out;
   }

   public Map<Denomination, Integer> getCash() {
        return cash;
   }
}
