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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return Collections.EMPTY_LIST;
        List<List<Integer>> x = new ArrayList<>();
        int h = getHeight(root);
        for(int i =0; i<h;i++){
            x.add(new ArrayList<Integer>());
        }
        BFS(x, root, 1, h);
        return x;
    }
	public void BFS(List<List<Integer>> x, TreeNode node, int l, int h){
        if(node == null) return;
        //System.out.println("L value " + l + "Node :: " + node.val);
        int b = l;
        BFS(x, node.left, l+1, h);
        l = b;
        BFS(x, node.right, b+1, h);
        x.get(h-l).add(node.val);
    }
    /*public void BFS(List<List<Integer>> x, TreeNode node, int l, int h){
        if(node == null) return;
        //System.out.println("L value " + l + "Node :: " + node.val);
        int b = l;
        
        if(node.left == null && node.right == null){
            x.get(h-l).add(node.val);
            return;
        } else if(node.left != null && node.right != null){
            x.get(h-l).add(node.val);
            BFS(x, node.left, ++l, h);
            BFS(x, node.right, ++b, h);
            return;
        }
        else if(node.left != null){
            x.get(h-l).add(node.val);
            BFS(x, node.left, ++l, h);
            return;
        }
        else if(node.right != null){
            x.get(h-b).add(node.val);
            BFS(x, node.right, ++b, h);
            return;
        }
    }*/
    public int getHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}