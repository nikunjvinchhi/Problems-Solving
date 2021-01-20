/**
1679. Max Number of K-Sum Pairs
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/
class Solution {
    // public int maxOperations(int[] nums, int k) {
    //     Map<Integer, Integer> t = new HashMap<>();
    //     int operation = 0;
    //     boolean y = false;
    //     for(int n : nums){
    //         int f = k - n;
    //         if(t.containsKey(f)){
    //             int x = t.get(f);
    //             if(x - 1 == 0){
    //                 t.remove(f);
    //             } else
    //                 t.put(f, x-1);
    //             operation++;
    //             y = true;
    //         }
    //         if(!y){
    //             int x = t.get(n) != null ? t.get(n) : 0;
    //             t.put(n,x+1);
    //         } else{
    //             y = false;
    //         }
    //     }
    //     return operation;
    // }
    //try with sort and two pointers.
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length-1;
        while(a < b){
            if(nums[a] + nums[b] > k ){
                b--;
            } else if(nums[a] + nums[b] < k ){
                a++;
            } else{
                count++;;
                a++;
                b--;
            }
        }
        return count;
    }
}