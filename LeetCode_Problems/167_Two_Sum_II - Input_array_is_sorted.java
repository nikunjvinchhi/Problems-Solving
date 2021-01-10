/**
167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/
class Solution {
    //using HashMap
    // public int[] twoSum(int[] numbers, int target) {
    //     Map<Integer,Integer> s = new HashMap<>();
    //         for(int i = 0; i<numbers.length; i++){
    //             int temp = target - numbers[i];
    //             if(s.containsKey(temp)){
    //                 return new int[] { s.get(temp), i+1 };
    //             }
    //             s.put(numbers[i], i+1);
    //         }
    //         throw new IllegalArgumentException("No two sum solution");
    // }
    //using Two pointer since array is sorted we can use
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j = numbers.length - 1;
        while(i < j){
            int t = numbers[i] + numbers[j];
            if(target == t){
                return new int[] {i+1, j+1};
            } else if(target > t){
                i++;
            } else{
                j--;
            }
        }
        return null;
    }
}