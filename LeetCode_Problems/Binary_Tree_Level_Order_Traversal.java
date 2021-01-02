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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return Collections.EMPTY_LIST;
        List<List<Integer>> x = new ArrayList<>();
        BFS(x, root, 1);
        return x;
    }
    public void BFS(List<List<Integer>> x, TreeNode node, int l){
        if(node == null) return;
        if(l > x.size()) {
            x.add(new ArrayList<Integer>());
            x.get(l - 1).add(node.val);
        } else {
            x.get(l - 1).add(node.val);
        }
        int b = l;
        BFS(x, node.left, ++l);
        BFS(x, node.right, ++b);
    }
    //Iterative Approach.
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return Collections.EMPTY_LIST;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> x = new ArrayList<>();
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            height++;
            int node = q.size();
            List<Integer> y = new ArrayList<>();
            while(node > 0){
                TreeNode n = q.peek();
                y.add(n.val);
                q.remove();
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
                node--;
            }
            x.add(y);
        }
        return x;
    }*/
}