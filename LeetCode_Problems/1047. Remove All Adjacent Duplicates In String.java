/**
1047. Remove All Adjacent Duplicates In String
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
*/
class Solution {
    // public String removeDuplicates(String s) {
    //     if(s == null || s.isEmpty() || s.length() == 1){
    //         return s;
    //     }
    //     StringBuilder t = new StringBuilder();
    //     Stack<Character> st = new Stack<>();
    //     int i=0;
    //     while(i < s.length()){
    //         if(st.isEmpty()){
    //             st.push(s.charAt(i));
    //         }else{
    //             if(st.peek() == s.charAt(i)){
    //                 st.pop();
    //             } else{
    //                 st.push(s.charAt(i));
    //             }
    //         }
    //         i++;
    //     }
    //     while(!st.isEmpty()){
    //         t.append(st.pop());
    //     }
    //     return t.reverse().toString();
    // }
    public String removeDuplicates(String s) {
        char[] t = new char[s.length()];
        int j=0;
        for(char x : s.toCharArray()){
            if(j != 0 && t[j -1] == x) j--;
            else{
                t[j] = x;
                j++;
            }
        }
        return new String(t, 0, j);
    }
}