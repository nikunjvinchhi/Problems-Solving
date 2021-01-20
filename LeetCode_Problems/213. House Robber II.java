/**
213. House Robber II
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [0]
Output: 0
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/
class Solution {
//     public int rob(int[] nums) {
//         if(nums.length == 1){
//             return nums[0];
//         }
//         if(nums.length == 2){
//             return Math.max(nums[0],nums[1]);
//         }
		
// 		// You can use just one dp[] array to store the biggest num as well
		
//         int []dp1 = new int[nums.length-1];
//         int []dp2 = new int[nums.length-1];
		
// 		// from 0 to nums.length-1, contains the first element but not the last 
//         for(int i=0;i<nums.length-1;i++){
//             if(i == 0){
//                 dp1[0] =  nums[i];
//             }else if (i == 1){
//                 dp1[1] = Math.max(nums[i],dp1[0]);
//             }else{
//                 dp1[i] = Math.max(dp1[i-1],nums[i] + dp1[i-2]);
//             }
//         }
// 		// from 1 to nums.length, contains the last element but not the first 
//         for(int i =1;i<nums.length;i++){
//             if(i == 1){
//                 dp2[0] = nums[i];
//             }else if (i == 2){
//                 dp2[1] = Math.max(nums[i],dp2[0]);
//             }else{
//                 dp2[i-1] = Math.max(dp2[i-1-1],nums[i]+ dp2[i-2-1]);
//             }
//         }
// 		// return the bigger result
//         return Math.max(dp1[nums.length-2],dp2[nums.length-2]);
//     }
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int a=0,b=0;
        int sum = 0;
        for(int i =0; i<nums.length - 1;i++){
            sum = Math.max(a+nums[i], b);
            a = b;
            b = sum;
        }
        int sum2 = 0;
        a=0;b=0;
        for(int i =1; i<nums.length;i++){
            sum2 = Math.max(a+nums[i], b);
            a = b;
            b = sum2;
        }
        return Math.max(sum,sum2);
    }
}