package com.gtnexus.tms.rating.businesslogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

   public static void main(String[] args) {
      String[] banned = new String[0];
      banned[0] = "hit";
      System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));
   }

   public static String mostCommonWord(String paragraph, String[] banned) {
      Set<String> temp = new HashSet<String>();
      for (String ban : banned) {
         temp.add(ban);
      }
      char[] str = paragraph.toLowerCase().toCharArray();
      Integer max = 0;
      Integer max1 = 0;
      String result = "";
      //System.out.println(list.length);
      Map<String, Integer> te = new HashMap<>();
      StringBuilder  sb = new StringBuilder ();
      for (char wordCh : str) {
         if (wordCh >= 'a' && wordCh <= 'z') {
            sb.append(wordCh);
         } else {
            if (sb.length() > 0) {
               String word = sb.toString();
               if (!temp.contains(word)) {
                  max = te.get(word);
                  max = (max == null) ? 1 : max.intValue() + 1;
                  te.put(word, max);
                  if (max > max1) {
                     max1 = max;
                     result = word;
                    //System.out.println(word);
                  }
               }
            }
            sb.setLength(0);
         }
      }
      if (sb.length() > 0) {
         String word = sb.toString();
         if (!temp.contains(word)) {
            max = te.get(word);
            max = (max == null) ? 1 : max.intValue() + 1;
            te.put(word, max);
            if (max > max1) {
               max1 = max;
               result = word;
            }
         }
      }
      return result;
   }
}
