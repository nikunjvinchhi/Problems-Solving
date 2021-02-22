/**
179. Largest Number
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] t = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            t[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(t, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String c = a + b;
                String d = b + a;
                return c.compareTo(d) > 0 ? -1 : 1;
            }
        });
        
        StringBuilder h = new StringBuilder();
        int count = 0;
        for(String g : t){
            if(g.equals("0")){
                count++;
            }
            h.append(g);
        }
        if(count == t.length) return "0";
        return h.toString();
    }
}