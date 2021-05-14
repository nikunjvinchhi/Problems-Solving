package com.gtnexus.tms.rating.businesslogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution2{
   public static void main(String[] args){
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input;
      try {
         input = br.readLine();
         String[] dictionary = br.readLine().split(" ");
         System.out.println(findLargest(input, dictionary));
      } catch (IOException e) {
      }
   }
   public static List<String> findLargest(String input, String[] dictionary){
      List<String> ans = new ArrayList<String>();
      int prelength = Integer.MIN_VALUE;
      int length = 0;
      for (String word : dictionary) {
         length = compare(input, word);
         if(prelength < length) {
            ans = new ArrayList<String>();
            ans.add(word);
            prelength = length;
         } else if(prelength == length) {
            ans.add(word);
         }
         length = word.length();
      }
      return ans;
   }
   public static int compare(String input, String word){
      int[] c = new int[26];
      int count = 0;
      //System.out.println(word);
      for(char ch : word.toCharArray()){
         c[ch - 'a']++;
      }
      for(char in : input.toCharArray()){
         if(c[in - 'a'] < 0){
            return count;
         } else if(c[in - 'a'] > 0)
            count++;
         c[in - 'a']--;
      }
      //System.out.println(count);
      return count;
   }
}