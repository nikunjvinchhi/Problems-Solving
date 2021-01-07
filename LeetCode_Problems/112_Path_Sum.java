/**
Problem Defination
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.
*/
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
    //recursive way 0ms
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if(root == null && sum > 0)
//             return false;
//         if(root == null && sum == 0)
//             return false;
//         if(root.right == null && root.left == null && sum == root.val)
//             return true;
//         boolean t = false;
//         if(root.left != null){
//             //System.out.println("Left " + sum + "Root "+ root.val);
//             t = hasPathSum(root.left, sum - root.val);
//         }
            
//         boolean r = false;
//         if(root.right != null){
//             //System.out.println("Right " + sum + "Root "+ root.val);
//             r = hasPathSum(root.right, sum - root.val);
//         }
        
//         return t || r;
//     }
    
    //iterative way took 1ms.
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null && sum > 0)
            return false;
        if(root == null && sum == 0)
            return false;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int back = sum;
        while(!st.isEmpty()){
            TreeNode r = st.pop();
            //sum = sum - r.val;
            if(r.left == null && r.right == null){
                if(back == r.val){
                    return true;    
                }
            }
            if(r.left != null){
                r.left.val = r.left.val + r.val;
                st.push(r.left);
            }
            if(r.right != null){
                r.right.val = r.right.val + r.val;
                st.push(r.right);
            }
        }
        return false;
    }
}