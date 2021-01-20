/**
152. Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    // public int maxProduct(int[] nums) {
    //     int max = 1;
    //     int min = 1;
    //     int answer = Integer.MIN_VALUE;
    //     for(int num : nums){
    //         int t = num * max;
    //         max = maximum(t, min*num,num);
    //         min = minimum(t, min*num, num);
    //         answer = Math.max(max , answer);
    //     }
    //     return answer;
    // }
    // public int maximum(int a,int b,int c){
    //     if(a > b)
    //         return a > c ? a : c;
    //     else
    //         return b > c ? b : c;
    // }
    // public int minimum(int a,int b,int c){
    //     if(a < b)
    //         return a < c ? a : c;
    //     else
    //         return b < c ? b : c;
    // }
    
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int a = 0;
        int b = 1;
        for(int i=0; i<nums.length;i++){
            b *= nums[i];
            a = Math.max(b, a);
            if(b == 0)
                b =1;
        }
        b = 1;
        for(int i=nums.length -1 ; i> -1;i--){
            b *= nums[i];
            a = Math.max(b, a);
            if(b == 0)
                b =1;
        }
        return a;
    }
}