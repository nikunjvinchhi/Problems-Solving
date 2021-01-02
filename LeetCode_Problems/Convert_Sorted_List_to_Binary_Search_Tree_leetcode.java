/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    ListNode t;
    public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
            return null;
        
        int size = 0;
        this.t = head;
        ListNode s = head;
        while(s != null){
            s = s.next;
            size++;
        }
        //System.out.println(size);
        return BST(0, size -1);
        
		//simple list traversal and recursive approach.
        /*
        ListNode s = head;
        ListNode lastNode = null;
        while(s.next != null)
            s = s.next;
        lastNode = s;
        s = head;
        return xyz(s, lastNode);*/
    }
	//Using concept of Inorcer Traversal.
    public TreeNode BST(int s, int l) {
        if(s > l)
            return null;
        
        int mid = (s + l) / 2;
        TreeNode left = this.BST(s, mid - 1);
        
        TreeNode root = new TreeNode(this.t.val);
        root.left = left;
        
        this.t = this.t.next;
        
        TreeNode right = this.BST(mid +1, l);
        root.right = right;
        return root;
        
    }
	//simple list traversal and recursive approach.
    public TreeNode xyz(ListNode s, ListNode lastNode){
        if(s == null || lastNode == null)
            return null;
        ListNode head = s;
        ListNode fast = s;
        ListNode p = null;
        while(fast != null && fast.next != null){
            p = s;
            s = s.next;
            fast = fast.next.next;
        }
        if(p != null) p.next = null;
        ListNode next = s.next;
        s.next = null;
        TreeNode root = new TreeNode(s.val);
        root.left = xyz(head, p);
        root.right = xyz(next, lastNode);
        
        return root;
    }
}