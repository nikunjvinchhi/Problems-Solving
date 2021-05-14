package com.gtnexus.tms.rating.businesslogic;

import java.util.Stack;

public class RemovalParanthesis {

   public static void main(String[] arags) {
      minRemoveToMakeValid("lee(t(c)o)de)");
   }

   public static String minRemoveToMakeValid(String s) {
      Stack<Character> stack2 = new Stack<Character>();
      StringBuffer j = new StringBuffer();
      for(int i=0; i<s.length(); i++){
          Character t = s.charAt(i);
          if(t == '(') {
              stack2.push(')');
              j.append(t);
          } else if(!stack2.empty() && stack2.pop() == t) {
              j.append(')');
          } else if(stack2.empty() && t != ')'){
              j.append(t);
          }
      }
      return j.toString();
  }
}
