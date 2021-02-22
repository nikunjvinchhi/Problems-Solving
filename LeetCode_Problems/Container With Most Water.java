//https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left =0;
        int right = height.length - 1;
        while(left < right){
            ans = Math.max(ans , (right- left) * Math.min(height[left], height[right]));
            
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        return ans;
    }
}