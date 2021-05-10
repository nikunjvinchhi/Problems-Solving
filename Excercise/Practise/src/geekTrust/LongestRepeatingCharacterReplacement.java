package geekTrust;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {

	}

	public static int characterReplacement(String s, int k) {
		Map<Character, Integer> t = new HashMap<>();
		int start =0;
		int maxfr=0;
		int maxLen = 0;
		int removed = 0;
		while(start < s.length()) {
			t.put(s.charAt(start), t.getOrDefault(s.charAt(start), 0) + 1);
			
			maxfr = Math.max(maxfr, t.get(s.charAt(start)));
			
			while(start - removed - maxfr + 1 > k) {
				t.put(s.charAt(removed), t.get(s.charAt(removed))-1);
				removed++;
				
			}
			maxLen = Math.max(maxLen, start + 1-removed);
			start++;
		}
		return maxLen;
    }
	
	
	public static int longestSubstring(String s, int k) {
		Map<Character, Integer> t = new HashMap<>();
		int start =0;
		int maxfr=0;
		int maxLen = 0;
		int removed = 0;
		while(start < s.length()) {
			t.put(s.charAt(start), t.getOrDefault(s.charAt(start), 0) + 1);
			
			maxfr = Math.max(maxfr, t.get(s.charAt(start)));
			
			while(maxfr == k) {
				maxLen = Math.max(maxLen, start + 1);
				
			}
			maxLen = Math.max(maxLen, start + 1-removed);
			start++;
		}
		return maxLen;
    }

}
