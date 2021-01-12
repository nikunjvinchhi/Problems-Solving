/**
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] y = s.toCharArray();
        if(s.length() <= 1)
            return s.length();
        int an = 0;
        int i =0;
        
        
        for(int j=1; j<s.length();j++){
            for(int k = i; k<j;k++){
                if(y[k] == y[j]){
                    i = k+1;
                    break;
                }
            }
            an = Math.max(an, j + 1 -i);
        }
        
        //int[] b = new int[128];//for ASCII
        // for(int j=0;j<s.length();j++){
        //     i = Math.max(b[s.charAt(j)], i);
        //     an = Math.max(an, j+1-i);
        //     b[s.charAt(j)] = j+1;//store current index
        // }
        
        // Map<Character, Integer> g = new HashMap<>();
        // for(int j=0;j<s.length();j++){
        //     if(g.containsKey(s.charAt(j))){
        //         i = Math.max(g.get(s.charAt(j)), i);
        //         //skip index duplicate abcba
        //         //reason to put max we are using indexing. 
        //     }
        //     g.put(s.charAt(j),j+1);
        //     //System.out.println(j+1);
        //     an = Math.max(an, j+1-i);
        //     //System.out.println(an);
        // }
        return an;
    }
}