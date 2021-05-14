package com.gtnexus.tms.rating.businesslogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Basically we need to print Largest connected components and then sort
 * @author nvinchhi
 *
 */
public class LargestItemAssociation {

   public static void main(String[] args) {

      List<PairString> itemAssociation = Arrays.asList(
            new PairString[]{
                    new PairString("item1", "item2"),
                    new PairString("item3", "item4"),
                    new PairString("item4", "item5")
            }
    );

      System.out.println(largestItemAssociation(itemAssociation));
   }

   public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
      Map<String, List<String>> t = new HashMap<>();
      for (PairString temp : itemAssociation) {
         t.putIfAbsent(temp.first, new ArrayList<String>());
         t.get(temp.first).add(temp.second);
         t.putIfAbsent(temp.second, new ArrayList<String>());
         t.get(temp.second).add(temp.first);
      }
      List<String> answer = new ArrayList<String>();
      Set<String> visited = new HashSet<>();
      for (String key : t.keySet()) {
         if (visited.contains(key)) {
         } else {
            List<String> compare = new ArrayList<String>();
            doDFS(key, t, visited, compare);
            if(compare.size() > answer.size()) {
               answer = compare;
            }
         }
      }
      answer.sort(Comparator.naturalOrder());
      return answer;
   }

   private static void doDFS(String key, Map<String, List<String>> t, Set<String> visited, List<String> compare) {
      if(visited.contains(key))
         return;
      visited.add(key);
      compare.add(key);
      for(String adj : t.get(key)) {
         doDFS(adj, t, visited, compare);
      }
   }
}

class PairString {
   String first;
   String second;

   public PairString(String first, String second) {
      this.first = first;
      this.second = second;
   }
}