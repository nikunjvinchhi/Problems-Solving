package geekTrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> t = new ArrayList<>();
		t.add("100563");
		t.add("sales");
		t.add("January");
		
		List<String> t1 = new ArrayList<>();
		t1.add("100563");
		t1.add("sales");
		t1.add("EMPTY");
		
		List<String> dis = new ArrayList<>();
		dis.add("sales");
		dis.add("1");
		dis.add("10");
		
		List<String> dis1 = new ArrayList<>();
		dis1.add("January");
		dis1.add("1");
		dis1.add("10");
		
		List<List<String>> di = new ArrayList<>();
		di.add(dis);
		di.add(dis1);
		List<List<String>> prod = new ArrayList<>();
		prod.add(t);
		prod.add(t1);
		calculate(prod, di);
	}

	public static void calculate(List<List<String>> products, List<List<String>> discounts) {
		Map<String, Integer> dis = new HashMap<>();
		Map<String, String> disType = new HashMap<>();

		for (List<String> d : discounts) {
			dis.put(d.get(0), Integer.valueOf(d.get(2)));
			disType.put(d.get(0), d.get(1));
		}
		int ans = 0;
		for (List<String> p : products) {
			int price = Integer.parseInt(p.get(0));
			int t = price;
			if (p.size() > 1) {
				for (int i = 1; i < p.size(); i++) {
					int finalPrice = 0;
					if (p.get(i) != null && !p.get(i).equalsIgnoreCase("Empty")) {
						if (disType.get(p.get(i)).equals("1")) {
							double pr = price;
							double discount = dis.get(p.get(i)) * 0.01;
							discount = discount * price;
							pr = pr - discount;
							finalPrice = (int) Math.round(pr);
						}
						t = Math.min(t, finalPrice);
					}
				}
			}
			ans += t;
		}
		System.out.println(ans);
	}
}
