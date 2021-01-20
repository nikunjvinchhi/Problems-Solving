/**
1209. Remove All Adjacent Duplicates in String II
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/
class Solution {
    // public String removeDuplicates(String s, int k) {
    //     if(s == null || s.isEmpty() || s.length() == 1){
    //         return s;
    //     }
    //     Stack<Pair> st = new Stack<>();
    //     for(char y : s.toCharArray()){
    //         if(st.isEmpty()){
    //             st.push(new Pair(y, 1));
    //         } else{
    //             if(st.peek().c == y && st.peek().x == k-1){
    //                 st.pop();
    //             } else if(st.peek().c == y){
    //                 //System.out.println(st.peek().c);
    //                 Pair z = st.pop();
    //                 z.x = z.x + 1;
    //                 st.push(z);
    //             } else{
    //                 st.push(new Pair(y, 1));
    //             }
    //         }            
    //     }
    //     StringBuilder g = new StringBuilder();
    //     while(!st.isEmpty()){
    //         Pair p = st.pop();
    //         for(int i = 0; i<p.x;i++)
    //             g.append(p.c);
    //     }
    //     return g.reverse().toString();
    // }
    public String removeDuplicates(String s, int k) {
        char a = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length();i++){
            if(a == s.charAt(i)){
                count++;
            } else{
                count = 1;
                a = s.charAt(i);
            }
            if(count == k){
                String y = s.substring(0, i-k+1) + s.substring(i+1);
                return removeDuplicates(y, k);
            }
        }
        return s;
    }
}
// class Pair{
//     char c;
//     int x;
    
//     Pair(char c, int x){
//         this.c = c;
//         this.x = x;
//     }
// }