package com.gtnexus.tms.rating.businesslogic;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(letterCasePermutation("a1b2"));
      System.out.println(letterCasePermutation("3z4"));
      System.out.println(letterCasePermutation("12345"));
      System.out.println(letterCasePermutation("a"));
      System.out.println(letterCasePermutation("0"));
   }

   public static List<String> letterCasePermutation(String S) {
      List<String> ans = new ArrayList<>();
      int countChar = 0;
      for(char c : S.toCharArray()){
          if((c > 64 && c < 91) || (c > 96 && c < 123)){
              countChar++;
          }
      }
      if(countChar == 0) {
         ans.add(S);
         return ans;
      }
      char[][] t = new char[countChar][2];
      int i=0;
      for(char c : S.toCharArray()){
          if(c > 64 && c < 91){
              t[i][0] = c;
              t[i++][1] = (char)(c + 32);
          } else if(c > 96 && c < 123){
              t[i][0] = c;
              t[i++][1] = (char)(c - 32);
          }
      }
      //make the combination Array.
      List<String> combinations = new ArrayList<String>();
      List<String> finalCombinations = new ArrayList<String>();
      StringBuilder comBuilder = new StringBuilder();
      for(i=0;i<countChar;i++){
          if(i==0){//base case
              combinations.add(t[i][0]+"");
              combinations.add(t[i][1]+"");
              finalCombinations.addAll(combinations);
          } else{
              combinations = new ArrayList<>();
              for(int j=0; j<finalCombinations.size();j++){
                   comBuilder.append(finalCombinations.get(j)).append(t[i][0]);
                   combinations.add(comBuilder.toString());
                   comBuilder = new StringBuilder();
                   comBuilder.append(finalCombinations.get(j)).append(t[i][1]);
                   combinations.add(comBuilder.toString());
                   comBuilder = new StringBuilder();
              }
              finalCombinations = new ArrayList<String>();
              finalCombinations.addAll(combinations);
          }
      }
      for(String g : combinations){
          StringBuilder com = new StringBuilder();
          int l=0;
          int p=0;
          while(l < S.length()){
              char h = S.charAt(l);
              if((h > 64 && h < 91) || (h > 96 && h < 123))
                  com.append(g.charAt(p++));
              else
                  com.append(h);
              l++;
          }
          ans.add(com.toString());
      }
      return ans;
  }
}
