/**
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class Solution {
//     public boolean isPalindrome(String s) {
//         if(s == null || s.length() < 2)
//             return true;
//         char[] a = s.toCharArray();
//         char[] b = s.toCharArray();
//         int length = s.length();
//         int i =0;
//         int j = s.length() - 1;
//         boolean ans = true;
//         while(i < j){
//             boolean isAvalid = isValid(a[i]);
//             boolean isBvalid = isValid(b[j]);
//             if(isAvalid && isBvalid){
//                 //System.out.println(a[i] + " "+ b[j]); 
//                 if(a[i] == b[j] || Character.toLowerCase(a[i]) == b[j] ||
// Character.toLowerCase(b[j]) == a[i])
//                     ans = true;
//                 else
//                     return false;
//                 i++;
//                 j--;
//             } else{
//                 if(!isAvalid){
//                     i++;
//                 }
//                 if(!isBvalid){
//                     j--;
//                 }
//                 if(!isAvalid && !isBvalid)
//                     ans = true;
//             }
//         }
//         return ans;
//     }
    public boolean isValid(char c){
        if(c > 64 && c < 91)
            return true;
        if(c > 96 && c < 123)
            return true;
        if(c > 47 && c < 58)
            return true;
        //System.out.println((int)c);
        return false;
    }
    public char convertToOne(char a){
        if(a - 'a' >= 0 && a - 'a' < 26){
            //System.out.println((int)(a - 'a' + 'A'));
            return (char)(a - 'a' + 'A');
        }
            
        return a;
    }
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2)
            return true;
        int i =0;
        int j = s.length() - 1;
        while(i < j){
            char c = convertToOne(s.charAt(i));
            char d = convertToOne(s.charAt(j));
            //System.out.println(c + " "+ d); 
            
            if(!isValid(c)){
                i++;
                continue;
            }
            if(!isValid(d)){
                j--;
                continue;
            }
            if(c == d){
                i++;
                j--;
            } else{
                return false;
            }
        }
        return true;
    }
}