package com.gtnexus.tms.rating.businesslogic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CountIndex {
   int count, index;

   // constructor for first occurrence
   public CountIndex(int index) {
      this.count = 1;
      this.index = index;
   }

   // method for updating count
   public void incCount() {
      this.count++;
   }
}


public class Game_of_Book_Cricket {

   static final int NO_OF_CHARS = 256;

   static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);

   /* calculate count of characters
      in the passed string */
   static void getCharCountArray(String str) {
      for (int i = 0; i < str.length(); i++) {
         // If character already occurred,
         if (hm.containsKey(str.charAt(i))) {
            // updating count
            hm.get(str.charAt(i)).incCount();
         }

         // If it's first occurrence, then store
         // the index and count = 1
         else {
            hm.put(str.charAt(i), new CountIndex(i));
         }
      }
   }

   /* The method returns index of first non-repeating
      character in a string. If all characters are repeating
      then returns -1 */
   static int firstNonRepeating(String str) {
      getCharCountArray(str);
      int result = Integer.MAX_VALUE, i;
      for (Map.Entry<Character, CountIndex> entry : hm.entrySet()) {
         int c = entry.getValue().count;
         int ind = entry.getValue().index;
         if (c == 1 && ind < result) {
            result = ind;
         }
      }

      return result;
   }

   // Driver method
   public static void main(String[] args) {
      /*          String str = "geeksforgeeks";
          int index = firstNonRepeating(str);

          System.out.println(
              index == Integer.MAX_VALUE
                  ? "Either all characters are repeating "
                        + " or string is empty"
                  : "First non-repeating character is "
                        + str.charAt(index));*/

      int[][] events = {{1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}};
      System.out.println(maxEvents(events));
   }

   public static int maxEvents(int[][] events) {
      Arrays.sort(events, new Comparator<int[]>() {
         @Override public int compare(int[] a, int[] b) {
            if (a[0] == b[0])
               return a[1] - b[1];
            return a[0] - b[0];
         }
      });
      /*for(int i=0; i< events.length;i++)
          System.out.println(events[i][0] + " " + events[i] [1]);*/
      int day = 1;
      int i = 0;
      int an = 0;
      int maxDay = 0;
      for (i = 0; i < events.length; i++) {
         if (maxDay < events[i][1])
            maxDay = events[i][1];
      }
      i = 0;
      Set<Integer> t = new HashSet<>();
      while (day <= maxDay) {
         int maxD = 0;
         i = 0;
         boolean g = false;
         while (i < events.length && events[i][0] <= day && !t.contains(i)) {
            if (events[i][1] <= day && !g) {
               t.add(i);
               g = true;
               an++;
            } else {
               if (maxD < events[i][1]) {
                  maxD = events[i][1];
               }
            }
            i++;
         }
         day = day + 1;
         if (day < maxD)
            maxD = day;
      }
      return an;
   }

   public static int minCost(int cost[][], int m, int n) {
      int table[][] = new int[m][n];
      table[0][0] = cost[0][0];//base case.

      //row 0.
      for (int i = 1; i < n; i++) {
         table[0][i] = table[0][i - 1] + table[0][i];
      }
      //column 0;
      for (int i = 1; i < n; i++) {
         table[i][0] = table[i - 1][0] + table[i][0];
      }
      //for other row and column.
      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
            table[i][j] = cost[i][j] + Math.min(Math.min(minCost(cost, i - 1, j - 1), minCost(cost, i - 1, j)), minCost(cost, i, j - 1));
         }
      }
      return table[m - 1][n - 1];
   }
}
