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
    public boolean isSymmetric(TreeNode root) {
        
        //iterative approach.
        if(root == null)
            return true;
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.right != null){
            if(root.left.val == root.right.val){
                
                Queue<TreeNode> a = new LinkedList<TreeNode> ();
                Queue<TreeNode> b = new LinkedList<TreeNode> ();
                
                a.add(root.left);
                b.add(root.right);
                
                while (!a.isEmpty() && !b.isEmpty()){
                    TreeNode c = a.peek();
                    TreeNode d = b.peek();
                    a.remove();
                    b.remove();
                    if(c.left != null && d.right != null){
                        if(c.left.val == d.right.val){
                            a.add(c.left);
                            b.add(d.right);
                        } else{
                            return false;
                        }
                    } else if(c.left == null && d.right == null){
                        
                    } else{
                        return false;
                    }
                    if(c.right != null && d.left != null){
                        if(c.right.val == d.left.val){
                            a.add(c.right);
                            b.add(d.left);
                        } else{
                            return false;
                        }
                    } else if(c.right == null && d.left == null){
                        
                    } else{
                        return false;
                    }
                }
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
        
        
        
        
        //Recursive Approach
        /*if(root == null)
            return true;
        if(root.left != null && root.right != null){
            if(root.left.val == root.right.val){
                return isChildSymmetric(root.left, root.right);
            } else{
                return false;
            }
        } else if(root.left == null && root.right == null){
            return true;
        } else{
            return false;
        }
        */
    }
	//Recursive Approach
    public boolean isChildSymmetric(TreeNode left, TreeNode right) {
        Boolean one = false;
        if(left.left != null && right.right != null){
            if(left.left.val == right.right.val){
                one = isChildSymmetric(left.left, right.right);
            } else{
        //return false;we can't return here result is depend on other part also.
                one = false;
            }
        } else if(left.left == null && right.right == null){
        //return true; we can't return here result is depend on other part also.
            one = true;
        } else{
        //return false;we can't return here result is depend on other part also.
            one = false;
        }
        Boolean two = false;
        if(left.right != null && right.left != null){
            if(left.right.val == right.left.val){
                two = isChildSymmetric(left.right, right.left);
            } else{
        //return false;we can't return here result is depend on other part also.
                two = false;
            }
        } else if(left.right == null && right.left == null){
        //return true; we can't return here result is depend on other part also.
            two = true;
        } else{
        //return false;we can't return here result is depend on other part also.
            two = false;
        }
        return one && two;
    }
}