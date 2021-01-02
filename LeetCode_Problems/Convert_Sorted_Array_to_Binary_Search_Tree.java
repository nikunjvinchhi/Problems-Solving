/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int s = 0;
        int l = nums.length-1;
        return BST(nums, s, l);
    }
    public TreeNode BST(int[] nums, int s, int l){
        if(s > l)
            return null;
        TreeNode root = new TreeNode();
        int mid = s + (l - s)/2;
        root.val = nums[mid];
        root.left = BST(nums, s, mid - 1);
        root.right = BST(nums, mid + 1, l);
        return root;
    }
}