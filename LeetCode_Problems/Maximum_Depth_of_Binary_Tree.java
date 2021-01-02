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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //return 1 + Math.max(height(root.left), height(root.right));
        //return 1 + Math.max(iterativeHeight(root.left), iterativeHeight(root.right));
        return iterativeHeight(root);
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return 1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public int iterativeHeight(TreeNode t){
        if(t == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);
        int height = 0;
        while(!q.isEmpty()){
            height++;
            int node = q.size();
            while(node > 0){
                TreeNode n = q.peek();
                q.remove();
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
                node--;
            }
        }
        return height;
    }
}