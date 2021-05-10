package geekTrust;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacters {
	public static void main(String[] args){
		String a = "abcdfbcade";
		findUniqueCharacters(a);
	}
	
	public static void findUniqueCharacters(String a){
		Map<Character, Integer> map = new LinkedHashMap<>();
		int[] freq = new int[26];
		char[] c = a.toCharArray();
		for(char d : c){
			map.put(d, map.getOrDefault(d, 0) + 1);
			freq[d-'a']++;
		}
		
//		for(char d : map.keySet()){
//			if(map.get(d) == 1){
//				System.out.println(d);
//				break;
//			}
//		}	
		
		for(char d : c) {
			if(freq[d-'a'] == 1) {
				System.out.println(d);
				break;
			}
		}
	}
}