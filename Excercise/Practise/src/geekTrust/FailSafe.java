package geekTrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FailSafe {

	public static void main(String[] args) {

		List<String> tx = new ArrayList<>();
		tx.add("1");
		tx.add("2");
		tx.add("3");
		Iterator<String> it = tx.iterator();
		while(it.hasNext()) {

			System.out.println(it.next());
			//tx.remove(2);
			it.remove();
		}
System.out.println("------------------");
		System.out.println(tx);
		
		
		String a="test";
		String b="sett";
		
		Map<Character, Integer> count = new HashMap<>();
		for(char x : a.toCharArray()) {
			count.put(x, count.getOrDefault(x, 0) + 1);
		}
		
		for(char x : b.toCharArray()) {
			count.put(x, count.getOrDefault(x, 0) - 1);
		}
		boolean found = false;
		for(char t : count.keySet()) {
			if(count.get(t) == 0) {
				found = true;
			} else {
				found = false;
				break;
			}
		}
		if(found) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}
		
		
		
		
		
		
		String g = "abc cd";
		
		char[] h = g.toCharArray();
		Stack<Character> j = new Stack<>();
		StringBuilder y = new StringBuilder();
		for(char c : h) {
			if(c == ' ') {
				while(!j.isEmpty()) {
					y.append(j.pop());
				}
				y.append(' ');
			} else {
				j.push(c);
			}
		}
		if (j.isEmpty()) {
			//last space should be reomve
		} else {
			while (!j.isEmpty()) {
				y.append(j.pop());
			}
		}
		g = y.toString();
		System.out.println(g);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
// test    
// sett
}
