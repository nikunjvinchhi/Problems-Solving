/**
Problem statement
Given a dictionary of the words(strings) which contains different words & you are given an input string e.g. “abd”. You need to find the largest word available in the supplied dictionary which can be made using the letters of input string. The returned word can contain only the same no of occurrences of the letters as given in the input string i.e. if a letter is given once then in the output it should be existed only once. Examples:
to banana toe dogs ababcd elephant
1, Dictionary {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”} and input string is “eot”. Output should be “toe”
2, Dictionary is same as specified in example a but the input string is “ogtdes” and the output is “dogs” and “toes”
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution{
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