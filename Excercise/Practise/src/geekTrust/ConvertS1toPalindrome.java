package com.gtnexus.tms.rating.businesslogic;

public class ConvertS1toPalindrome {

   public static void main(String[] args) {
      System.out.println(minimumCost("aaaaa", "bbb"));
      System.out.println(minimumCost("archit", "ar"));
   }


   private static int minimumCost(String string, String string2) {
      int a = string.length();
      int b = string2.length();
      int minCost = Integer.MAX_VALUE;
      for(int i=0; i<(a-b+1);i++) {
         String t = string.substring(0, i) + string2 + string.substring(i+b);
         //check initial cost.
         int cost = 0;
         for(int j=0; j<a;j++) {
            if(t.charAt(j) != string.charAt(j))
               cost++;
         }
         //check weather Generated String is Palindrome or not.
         //if not then find the cost to make it palindrome.
         for(int j=0; j<(a/2); j++) {
            if(t.charAt(j) != t.charAt(a - j -1)) {
               cost++;
            }
         }
         if(minCost > cost) {
            minCost = cost;
         }
      }
      return minCost;
   }

}
