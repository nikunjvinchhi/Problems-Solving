/**
Problem
1382. Balance a Binary Search Tree
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.
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
    int[] inOrd = new int[10001];
    int len = 0;
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return null;
        //List<Integer> t = new LinkedList<>();
        //inorder(root,t);
        inorder(root);
        int s =0;
        //int l = t.size() - 1;
        int l = len - 1;
        //return makeBalanceBST(t, s, l);
        return makeBalanceBST(s, l);
    }
    // public void inorder(TreeNode root, List<Integer> t){
    //     if(root == null)
    //         return ;
    //     inorder(root.left, t);
    //     t.add(root.val);
    //     inorder(root.right,t);
    // }
    // public TreeNode makeBalanceBST(List<Integer> t, int s, int l){
    //     if(s > l)
    //         return null;
    //     int mid = (s + l)/2;
    //     TreeNode root = new TreeNode(t.get(mid));
    //     root.left = makeBalanceBST(t, s, mid -1);
    //     root.right = makeBalanceBST(t, mid+1, l);
    //     return root;
    // }
    public void inorder(TreeNode root){
        if(root == null)
            return ;
        inorder(root.left);
        inOrd[len++] = root.val;
        inorder(root.right);
    }
    public TreeNode makeBalanceBST(int s, int l){
        if(s > l)
            return null;
        int mid = (s + l)/2;
        TreeNode root = new TreeNode(inOrd[mid]);
        root.left = makeBalanceBST(s, mid -1);
        root.right = makeBalanceBST(mid+1, l);
        return root;
    }
}