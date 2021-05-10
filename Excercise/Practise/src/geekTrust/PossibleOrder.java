package geekTrust;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PossibleOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] cost = new double[6];
		cost[0] = 2.15;
		cost[1] = 2.75;
		cost[2] = 3.35;
		cost[3] = 3.55;
		cost[4] = 4.20;
		cost[5] = 5.80;
		
		possibleOrders(4.30, cost);
		
		possibleOrders(6.45, cost);
		
		possibleOrders(5.50, cost);
		
		possibleOrders(15.05, cost);
		
	}
	
	public static void possibleOrders(double amount, double[] cost) {
		List<String> x = new ArrayList<>();
		makeCombinations(amount, cost, 0, x, "");
		System.out.println(x);
	}
	
	public static void makeCombinations(double amount, double[] cost, int start, List<String> x, String g) {
		if(amount == 0.0) {
			x.add(g);
			return;
		}
		
		if(start >= cost.length)
			return;
		
		if(amount < 0.0)
			return;
		
		double h = BigDecimal.valueOf(amount).subtract(BigDecimal.valueOf(cost[start])).doubleValue();
		makeCombinations(h, cost, start, x, g + " " + cost[start]);
		
		makeCombinations(amount, cost, start + 1, x, g);
	}

}
