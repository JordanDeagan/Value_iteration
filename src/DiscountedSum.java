import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class DiscountedSum {
    static public double expectedValue(double discount, Square start, int turns){
        if (turns==1){

            return start.getValue();
        }
        else if (turns>1){
            Double optimalMove = null;
            ArrayList<Square> n = start.getNeighbors();
//            System.out.println(start);
            for (int i = 0;i<4;i++){
//                System.out.println(n.get(i) + " is " + i);
                if (n.get(i) == null){
                    continue;
                }
                double value = start.getValue();
                ArrayList<Square> options = start.moveOptions(i);
                double sumer = 0.8 * expectedValue(discount,options.get(0),turns-1);
                Square perp;
                if(options.get(1) == null){
                    perp = start;
                } else {
                    perp = options.get(1);
                }
                sumer += 0.1 * expectedValue(discount,perp,turns-1);
                if(options.get(2) == null){
                    perp = start;
                } else {
                    perp = options.get(2);
                }
                sumer += 0.1 * expectedValue(discount,perp,turns-1);
                value += discount * sumer;
//                System.out.println(value);
                if(optimalMove==null || value>optimalMove){
                    optimalMove = value;
                }
            }
//            System.out.println("next");
            BigDecimal temp = new BigDecimal(optimalMove).setScale(2, RoundingMode.HALF_UP);
            return temp.doubleValue();
        }
        else {
            return 0;
        }
    }
}
