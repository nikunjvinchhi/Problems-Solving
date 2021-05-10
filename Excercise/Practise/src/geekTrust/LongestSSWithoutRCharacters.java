package geekTrust;

import java.util.HashMap;
import java.util.Map;

public class LongestSSWithoutRCharacters {

	public static void main(String[] args) {
		System.out.println(longestString("ABDEFGABEF"));
		System.out.println(longestString("dvdf"));
		System.out.println(longestString("abcdcdeffegh"));
		System.out.println(longestString("abccxyz"));
	}

	/*
	 * GEEKSFORGEEKS
	 * EKSFORG
	 * ABDEFGABEF
	 * BDEFGA
	 */
	public static String longestString(String s) {
		Map<Character, Integer> temp = new HashMap<>();
        int maxLen = 0;
        int i=0;
        int start = 0;
        
        for(int a=0;a<s.length();a++){
            
            char f = s.charAt(a);
            
            if(temp.containsKey(f)){
                if(i <= temp.get(f)){
                    i = temp.get(f) + 1;
                }
            }
            if(maxLen <= a + 1 - i){
                maxLen = a + 1 - i;
                start = i;
            }
            temp.put(f, a);
            
        }
        return s.substring(start, start+maxLen);
	}
}
