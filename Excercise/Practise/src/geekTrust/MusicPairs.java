package com.gtnexus.tms.rating.businesslogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicPairs {
   public static void main(String[] args) {

      List<Integer> temp = new ArrayList<Integer>();
      /*temp.add(30);
      temp.add(20);
      temp.add(150);
      temp.add(100);
      temp.add(40);*/
      /*temp.add(60);
      temp.add(60);
      temp.add(60);*/
      /*temp.add(10);
      temp.add(50);
      temp.add(90);
      temp.add(30);*/
      //37, 23, 60
      temp.add(37);
      temp.add(23);
      temp.add(60);
      long count = getSongPairCount(temp);
      System.out.println(count);
   }

   public static long getSongPairCount(List<Integer> songs) {
      //Set<Integer> temp= new HashSet<>();
      Map<Integer, Integer> t = new HashMap<>();
      long result = 0;
      for (int i = 0; i < songs.size(); i++) {
         int duration = songs.get(i) % 60;
         int exp = 60 - duration == 60 ? 0 : 60 - duration;
         /*         if(temp.contains(exp)) {
         result++;
               }
               temp.add(duration);*/
         if (t.containsKey(exp)) {
            result += t.get(exp);
         }
         t.put(duration, t.getOrDefault(duration, 0) + 1);
      }
      return result;
   }
}
