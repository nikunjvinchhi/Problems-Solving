//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class Solution {
	// public String minRemoveToMakeValid(String s) {
	// Stack<Integer> stack2 = new Stack<Integer>();
	// 	StringBuffer j = new StringBuffer();
	// 	for (int i = 0; i < s.length(); i++) {
	// 		Character t = s.charAt(i);
	// 		if (t == '(') {
	// 			stack2.push(j.toString().length());
	// 			j.append(t);
	// 		} else if (!stack2.empty() && t == ')') {
	// 			j.append(')');
	// 			stack2.pop();
	// 		} else if (stack2.empty() && t == ')') {
	// 		} else {
	// 			j.append(t);
	// 		}
	// 	}
	// 	while(!stack2.empty()) {
	// 		int pos = stack2.pop();
	// 		j = new StringBuffer(j.substring(0, pos).concat(j.substring(pos+1)));
	// 	}
	// 	return j.toString();
	// }
    //Basically Using stack we are maintain remaing position that we should not use. Try to use array for that.
    // public String minRemoveToMakeValid(String s) {
    //     int l = s.length();
    //     int[] stack = new int[l];
    //     char[] t = s.toCharArray();
    //     int maintain = 0;
    //     for(int i=0; i<l;i++){
    //         if(t[i] == '(') {
    //             stack[maintain++] = i; //keep track of position.
    //         } else if(t[i] == ')') {
    //             if(maintain <= 0){// we have to remove ')' from string.
    //                 t[i] = '0';
    //             } else{
    //                 maintain--; // found matching ')'.
    //             }
    //         }
    //     }
    //     for(int i=0; i<maintain;i++){//if more number of unmatched '(' found then do '0' that we will skip
    //         t[stack[i]] = '0';
    //     }
    //     StringBuilder ans = new StringBuilder();
    //     for(int i=0;i<l;i++){
    //         if(t[i] != '0')
    //             ans.append(t[i]);
    //     }
    //     return ans.toString();
    // }
    public static String minRemoveToMakeValid(String s) {
		Stack<Integer> stack2 = new Stack<Integer>();
		StringBuffer j = new StringBuffer();
		char[] cg = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			Character t = s.charAt(i);
			if (t == '(') {
				stack2.push(i);
			} else if (!stack2.empty() && t == ')') {
				stack2.pop();
			} else if (stack2.empty() && t == ')') {
				cg[i]='0';
			}
		}
		while(!stack2.empty()) {
			cg[stack2.pop()] = '0';
		}
		for(int i=0; i<s.length();i++) {
			if(cg[i] != '0') {
				j.append(cg[i]);
			}
		}
		return j.toString();
	}
}