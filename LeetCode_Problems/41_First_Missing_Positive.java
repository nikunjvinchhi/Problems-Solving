/**
41. First Missing Positive
Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        //move all positive to one side and negative to different side
        int j=0;
       for(int i=0; i<nums.length; i++){
           if(nums[i] <= 0){
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
               j++;
           }
       }
        
        for(int i=j; i<nums.length; i++){
           int x = Math.abs(nums[i]);
            int temp = x-1 + j;
           if(x != Integer.MAX_VALUE && temp >= 0 && temp < nums.length && nums[x-1 + j] >0){
               nums[x-1 + j] = -nums[x-1 + j];
           }
       }
       for(int i=j; i<nums.length; i++){
           if(nums[i] > 0)
               return i + 1 - j;
       }
       return (nums.length- j + 1);
    }
}