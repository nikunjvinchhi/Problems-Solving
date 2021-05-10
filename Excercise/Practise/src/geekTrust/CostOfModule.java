package geekTrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CostOfModule {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("A,S,G,N");
		input.add("S,H,N");
		input.add("G,H,N");;
		System.out.println(costOfModule(input));
	}

	public static List<String> costOfModule(List<String> graph) {
		List<String> ans = new ArrayList<>();

		Map<String, List<String>> temp = new HashMap<>();

		for (String t : graph) {
			String[] ty = t.split(",");
			if (ty.length > 1) {
				for (int i = 1; i < ty.length; i++) {
					temp.putIfAbsent(ty[i], new ArrayList<>());
					temp.get(ty[i]).add(ty[0]);
					temp.putIfAbsent(ty[0], new ArrayList<>());
				}
			} else {
				temp.putIfAbsent(ty[0], new ArrayList<>());
			}
		}
		
		System.out.println();

		for (String key : temp.keySet()) {
			int[] count = new int[1];
			count[0]++;
			Set<String> visited = new HashSet<>();
			doDFS(key, temp, visited, count);
			ans.add(key + "," + count[0]);
		}
		Collections.sort(ans);
		return ans;
	}

	public static void doDFS(String origin, Map<String, List<String>> temp, Set<String> visited, int[] count) {
		if (visited.contains(origin))
			return;
		visited.add(origin);
		if (temp.get(origin) != null && temp.get(origin).size() > 0) {
			for (String next : temp.get(origin)) {
				if (!visited.contains(next)) {
					count[0]++;
					doDFS(next, temp, visited, count);
				}
			}
		}
	}
}
