/**
1721. Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
*/
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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null){
            return head;
        }
        if(head.next == null && k == 1){
            return head;
        }
        if(head.next.next == null && k == 1){
            ListNode t = head.next;
            head.next.next = head;
            head.next = null;
            return t;
        }
        ListNode x=head;
        ListNode prev = null;
        for(int i=0;i<k-1;i++){
            prev = x;
            x = x.next;
        }
        ListNode z = x;
        ListNode y = head;
        ListNode prev_y = null;
        while(z.next != null){
            prev_y = y;
            y = y.next;
            z=z.next;
        }
        // System.out.println(prev_r.val);
        // System.out.println(y.val);
        // System.out.println(x.val);
        // System.out.println(prev.val);
        if (prev != null) 
            prev.next = y; 
        else //make y the new head 
            head = y;
        
        if (prev_y != null) 
            prev_y.next = x; 
        else // make x the new head 
            head = x; 
  
        // Swap next pointers 
        ListNode temp = x.next; 
        x.next = y.next; 
        y.next = temp; 
        return head;
    }
}