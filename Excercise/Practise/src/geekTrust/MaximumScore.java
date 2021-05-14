package com.gtnexus.tms.rating.businesslogic;

import java.util.Arrays;

public class MaximumScore {

   public static void main(String[] args) {

      maximumScore(new int[] {-5,-3,-3,-2,7,1}, new int[] {-10,-5,3,4,6});
   }

   public static int maximumScore(int[] nums, int[] multipliers) {
      Arrays.sort(nums);
      Arrays.sort(multipliers);
      int ans=0;
      int k=0;
      int j = 0;
      for(int i=0; i<multipliers.length;i++){
          int mul = multipliers[i];
          if(mul < 0){
              ans += (mul * nums[k++]);
          } else{
              j=i;
              break;
          }
      }
      int p = nums.length-1;
      for(int i = multipliers.length - 1; i >=j; i--){
          int mul = multipliers[i];
          if(p >= k)
              ans += (mul * nums[p--]);
          else
              break;
      }
      return ans;
  }
}
