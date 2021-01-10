/**
394. Decode String
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*/
class Solution {
    public String decodeString(String s) {
        StringBuilder z = new StringBuilder();
        Stack<Character> t = new Stack<>();
        boolean isFound = false;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == ']'){
                isFound = true;count=0;
                StringBuilder x = new StringBuilder();
                while(t.peek() != '['){
                    x.append(t.pop());
                }
                t.pop();
                x.reverse();
                //System.out.println(t.pop() + " " + t.pop());
                int digit = 0;
                int u = 0;
                while(!t.isEmpty() && t.peek() > 47 && t.peek() < 58){
                    digit = (int) ((t.pop() - 48) * (Math.pow(10,u))) + digit;
                    u++;
                }
                StringBuilder y = new StringBuilder();
                for(int i =0; i < digit; i++){
                    y.append(x.toString());
                }
                //z.append(y.toString());
                if(!t.isEmpty() && t.peek() != null && ((t.peek() > 96 && t.peek() < 123) ||  t.peek() == '[')){
                    // if(!t.isEmpty())
                    //     System.out.println(digit + " " + t.peek());
                    for(char v : y.toString().toCharArray()){
                        isFound = false;
                        t.push(v);    
                    }
                } else{
                    
                    z.append(y.toString());
                }
            } else{
                t.push(c);
                isFound = false;
                count++;
            }
        }
        if(!isFound){
            StringBuilder g = new StringBuilder();
            while(count > 0){
                //System.out.println(count);
                count--;
                g.append(t.pop());  
            }
            //boolean isStack = false;
            StringBuilder g1 = new StringBuilder();
            while(!t.isEmpty()){
                //isStack = true;
               g1.append(t.pop());
             }
            // if(isStack)
            //     g1.reverse();
             
            z.append(g1.reverse().toString()); 
            z.append(g.reverse().toString());
        }
        return z.toString();
    }
}