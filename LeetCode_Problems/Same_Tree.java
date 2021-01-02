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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //we can use Queue Or stack where we will store root and their children.
        if(p == null && q ==null)
            return true;
        if(p != null && q != null) {
            Queue<TreeNode> a = new LinkedList<TreeNode> ();
            Queue<TreeNode> b = new LinkedList<TreeNode> ();

            a.add(p);
            b.add(q);

            while (!a.isEmpty() && !b.isEmpty()){
                TreeNode c = a.peek();
                TreeNode d = b.peek();
                System.out.println(c.val + " " + d.val);
                if(c.val != d.val){
                    return false;
                }
                a.remove();
                b.remove();
                if(c.left != null && d.left !=null){
                    a.add(c.left);
                    b.add(d.left);
                } else if(c.left == null && d.left ==null) {} else
                    return false;
                if(c.right != null && d.right !=null){
                    a.add(c.right);
                    b.add(d.right);
                } else if(c.right == null && d.right ==null){} else
                    return false;
            }
            return true;
        } else{
        return false;
        }
        
        /*if(p == null && q == null)
            return true;
        if(p != null && q != null){
            return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;*/
    }
}