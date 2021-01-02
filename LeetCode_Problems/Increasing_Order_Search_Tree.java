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
    TreeNode x;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode re = new TreeNode(0);
        TreeNode y = re;
        
        //Iterative Approach.
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        root = root.left;
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            TreeNode a = st.pop();
            y.right = a;
            a.left = null;
            y = a;
            if(a.right != null)
                root = a.right;
        }
        
        /*
        x = re;
        Recurasive Appriach with relinking.
        increasingOrder(root);*/
        return re.right;
    }
    
    //relinking approach.
    public void increasingOrder(TreeNode node){
        if(node == null)
            return;
        increasingOrder(node.left);
        node.left = null;
        x.right = node;
        x = node;// make current one.
        increasingOrder(node.right);
    }
}