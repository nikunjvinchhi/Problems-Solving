package geekTrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ProcessLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> logs = new ArrayList<String>();
		logs.add("9 7 50");
		logs.add("22 7 50");
		logs.add("33 7 50");
		logs.add("22 7 50");
		System.out.println(processLogs(logs, 3));

		logs.clear();
		logs.add("1 2 50");
		logs.add("1 7 50");
		logs.add("1 3 50");
		logs.add("2 2 50");
		System.out.println(processLogs(logs, 2));

	}

	public static List<String> processLogs(List<String> logs, int thresold) {
		List<String> ans = new ArrayList<>();

		if (logs != null && logs.size() > 0) {
			PriorityQueue<String> temp = new PriorityQueue<>();
			Map<String, Integer> mem = new HashMap<>();
			// Set<String> t = new HashSet<>();
			for (String log : logs) {
				String[] sub = log.split(" ");
				if(sub[0].equals(sub[1])) {
					mem.put(sub[0], mem.getOrDefault(sub[0], 0) + 1);
				} else {
					mem.put(sub[0], mem.getOrDefault(sub[0], 0) + 1);
					mem.put(sub[1], mem.getOrDefault(sub[1], 0) + 1);	
				}
				// if (mem.get(sub[0]) >= thresold && !t.contains(sub[0])) {
				// temp.add(sub[0]);
				// t.add(sub[0]);
				// }
				// if (mem.get(sub[1]) >= thresold && !t.contains(sub[1])) {
				// temp.add(sub[1]);
				// t.add(sub[1]);
				// }
			}
			for (String key : mem.keySet()) {
				if (mem.get(key) >= thresold) {
					temp.add(key);
				}
			}

			while (!temp.isEmpty()) {
				ans.add(temp.poll());
			}
		}
		return ans;
	}

}
