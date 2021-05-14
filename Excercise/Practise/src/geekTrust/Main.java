package com.gtnexus.tms.rating.businesslogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Main {

   public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
      Arrays.sort(candidates);
      return recursiveFunction(0,target,candidates);
  }
  public static List<List<Integer>> recursiveFunction(int s, int target, int[] candidates){
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      for(int i = s; i<candidates.length; i++){
          if(candidates[i] < target){
              List<List<Integer>> temp = recursiveFunction(i, target-candidates[i], candidates);
              for(List<Integer> l : temp){
                  l.add(candidates[i]);
                  result.add(l);
              }
          } else if(candidates[i] == target){
              List<Integer> res = new ArrayList<>();
              res.add(candidates[i]);
              result.add(res);
          } else{
              break;
          }
      }
      return result;
  }

   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> curr = new ArrayList<Integer>();
      //Arrays.sort(candidates);
      helper(result, curr, 0, target, candidates);
      return result;
  }

  public static void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
      if(target==0){
          result.add(new ArrayList<Integer>(curr));
          return;
      }
      if(target<0){
          return;
      }

      int prev=-1;
      for(int i=start; i<candidates.length; i++){
          if(prev!=candidates[i]){
              curr.add(candidates[i]);
              helper(result, curr, i, target-candidates[i], candidates);
              curr.remove(curr.size()-1);
              prev=candidates[i];
          }
      }
  }
   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      Map<Integer, Integer> temp = new HashMap<>();

      List<List<Integer>> result = new ArrayList<List<Integer>>();
      for (int i = 0; i < candidates.length; i++) {
         temp.putIfAbsent(candidates[i], 0);
      }

      for (int i = 0; i < candidates.length; i++) {
         int a = candidates[i];
         int original = 0;
         List<Integer> b = new ArrayList<>();
         List<Integer> c = new ArrayList<>();
         if (a == target) {
            b.add(a);
            result.add(b);
         } else {
            int j = a;
            while (a < target) {
               if (a == target) {
                  b.add(a);
               } else {
                  c.add(a - original);
                  if (temp.containsKey(target - a)) {
                     b.add(a - original);
                     b.add(target - a);
                     result.add(b);
                     b = c;
                  } else {
                     b.add(a - original);
                  }
               }
               original = a;
               a = a + j;
            }
         }
      }

      return result;
   }

   public static int firstMissingPositive(int[] nums) {

      //move all positive to one side and negative to different side
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] <= 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
         }
      }

      for (int i = j; i < nums.length; i++) {
         int x = Math.abs(nums[i]);
         int temp = x - 1 + j;
         if (x != Integer.MAX_VALUE && temp >= 0 && temp < nums.length && nums[x - 1 + j] > 0) {
            nums[x - 1 + j] = -nums[x - 1 + j];
         }
      }
      for (int i = j; i < nums.length; i++) {
         if (nums[i] > 0)
            return i + 1 - j;
      }
      return (nums.length - j + 1);
   }

   public static void main(String[] args) {
      JSONObject finalO = new JSONObject();
      JSONObject main = new JSONObject();
      JSONObject t = new JSONObject();
      JSONObject aux = new JSONObject();
      t.put("rateId", 1);
      t.put("equipment", 2);

      aux.put(0, t.toString());
      main.put("AuxArray", aux);
      main.put("city", "xyz");

      finalO.put(1, main.toString());

      String y = finalO.toString();
      JSONParser parser = new JSONParser();
      try {
         JSONObject json = (JSONObject) parser.parse(y);
         if(json != null && json.get("1") != null) {
            String data1 = json.get("1").toString();
            JSONObject json1 = (JSONObject) parser.parse(data1);
            JSONObject json2 = (JSONObject) parser.parse(json1.get("AuxArray").toString());
            int d = json2.size();
            aux = new JSONObject();
            JSONObject o = new JSONObject();
            t.put("rateId", 3);
            t.put("equipment", 2);
            json2.put(d, t.toString());
            json1.put("AuxArray", json2);
            System.out.println("J1");
         }
         } catch(Exception e) {

         }


      //int arr[] = {1};
      //int arr[] = {2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648};
      //int arr[] = {2};
      //int arr[] = {1,2,0};
      int arr[] = {8,7,4,3};
      int arr_size = arr.length;
      //int missing = firstMissingPositive(arr);
      System.out.println(combinationSum3(arr, 11));
      //System.out.println("The smallest positive missing number is " + missing);
   }
}
/*
class Main {

   static int segregate(int arr[], int size) {
      int j = 0, i;
      for (i = 0; i < size; i++) {
         if (arr[i] <= 0) {
            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            // increment count of non-positive
            // integers
            j++;
         }
      }

      return j;
   }


   static int findMissingPositive(int arr[], int size) {
      int i;

      // Mark arr[i] as visited by making
      // arr[arr[i] - 1] negative. Note that
      // 1 is subtracted because index start
      // from 0 and positive numbers start from 1
      for (i = 0; i < size; i++) {
         int x = Math.abs(arr[i]);
         if (x - 1 < size && arr[x - 1] > 0)
            arr[x - 1] = -arr[x - 1];
      }

      // Return the first index value at which
      // is positive
      for (i = 0; i < size; i++)
         if (arr[i] > 0)
            return i + 1; // 1 is added becuase indexes
      // start from 0

      return size + 1;
   }

   static int findMissing(int arr[], int size) {
      // First separate positive and
      // negative numbers
      int shift = segregate(arr, size);
      System.out.println(shift);
      int arr2[] = new int[size - shift];
      int j = 0;
      for (int i = shift; i < size; i++) {
         arr2[j] = arr[i];
         j++;
      }
      // Shift the array and call
      // findMissingPositive for
      // positive part
      return findMissingPositive(arr2, j);
   }

   // main function
   public static void main(String[] args) {
      int arr[] = {1,2,0};
      int arr_size = arr.length;
      int missing = findMissing(arr, arr_size);
      System.out.println("The smallest positive missing number is " + missing);
   }
}
*/