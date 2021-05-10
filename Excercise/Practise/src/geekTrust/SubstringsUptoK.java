package geekTrust;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringsUptoK {

   public static void main(String[] args) {

      //String s = "awaglk";
      String s = "abcadce";
      Set<Character> t = new HashSet<>();
      for(char g : s.toCharArray()) {
    	  t.add(g);
      }
      int k = 4;

      //List<String> t = new ArrayList<>();
      Map<Character, Integer> h = new HashMap<>();
      StringBuffer temp = new StringBuffer();
      int count = 0;
      for (int i = 0; i < k; i++) {
         temp.append(s.charAt(i));
         if (h.get(s.charAt(i)) == null) {
            h.put(s.charAt(i), 1);
         } else {
            h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
         }
      }
      if (h.size() == (k)) {
         count++;
         System.out.println(temp.toString());
         //t.add(temp.toString());
      }

      int j = 1;
      String answer = temp.toString();
      for (int i = k; i < s.length(); i++) {
         if (h.get(s.charAt(i)) == null) {
            h.put(s.charAt(i), 1);
         } else {
            h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
         }
         //decrese the count of i-k sliding window 1st character
         h.put(s.charAt(i - k), h.get(s.charAt(i - k)) - 1);
         answer = answer.substring(1, k).concat("" + s.charAt(i));
         if (h.get(s.charAt(i - k)) == 0) {
            h.remove(s.charAt(i - k));
         }
         if (h.size() == (k)) {
            count++;
            System.out.println(answer);
            //t.add(answer);
         }

      }
      System.out.println("Count :: " + count);
   }
}
