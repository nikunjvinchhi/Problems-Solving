package com.gtnexus.tms.rating.businesslogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hello1 {

   public static void main(final String[] args) {
      List<List<String>> itemAssociation = new ArrayList<List<String>>();
      System.out.println(foo(itemAssociation));
   }

   private static List<String> foo(List<List<String>> itemAssociation) {
      List<PairString> listb = new ArrayList<PairString>();
      for(List<String> a : itemAssociation) {
         listb.add(new PairString(a.get(0),a.get(1)));
      }
      return largestItemsAssociationAnswer(listb);

   }
   private static List<String> largestItemsAssociationAnswer(final List<PairString> itemAssociation) {


      final UnionFindClass uf = new UnionFindClass();
      uf.initialize(itemAssociation);

      for (PairString pair : itemAssociation) {
         uf.unionOperation(pair.first, pair.second);
      }

      String largest = "";
      int max = Integer.MIN_VALUE;
      for (Map.Entry<String, GroupClass> entry : uf.map.entrySet()) {
         if (entry.getValue().items.size() > max) {
            max = entry.getValue().items.size();
            largest = entry.getKey();
         } else if(entry.getValue().items.size() == max) {
            final String key = String.join("", uf.map.get(largest).items);
            if(String.join("", uf.map.get(entry.getKey()).items).compareTo(key) < 0) {
               largest = entry.getKey();
            }
         }
      }

      return uf.map.get(largest).items;
   }

   static class PairString {
      String first;
      String second;

      PairString(final String first, final String second) {
         this.first = first;
         this.second = second;
      }
   }

   static class UnionFindClass {
      final Map<String, GroupClass> map = new HashMap<>();

      void initialize(final List<PairString> pairs) {

         for (final PairString pair : pairs) {
            final GroupClass first = new GroupClass(pair.first);
            final GroupClass second = new GroupClass(pair.second);

            first.items.add(pair.first);
            second.items.add(pair.second);

            map.put(pair.first, first);
            map.put(pair.second, second);
         }
      }

      void unionOperation(final String a, final String b) {
         final String parentA = findOperation(a);
         final String parentB = findOperation(b);

         if (!parentA.equals(parentB)) {
            map.get(parentB).parent = parentA;
            for(String childOfB : map.get(parentB).items) {
               map.get(parentA).items.add(childOfB);
            }
         }

      }

      String findOperation(final String a) {

         if (map.get(a).parent.equals(a)) {
            return a;
         }

         return findOperation(map.get(a).parent);
      }
   }

   static class GroupClass {
      String parent;
      List<String> items;

      GroupClass(final String parent) {
         this.parent = parent;
         this.items = new ArrayList<>();

      }
   }

}
