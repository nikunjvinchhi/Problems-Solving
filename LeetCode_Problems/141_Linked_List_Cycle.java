/**
Problem
141. Linked List Cycle
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode t = head;
        while(head != null && head.next != null){
            head = head.next.next;
            t = t.next;
            if(t == head)
                return true;
        }
        return false;
    }
    // public boolean hasCycle(ListNode head) {
    //     if(head == null)
    //         return false;
    //     ListNode t = head.next;
    //     while(head != t){
    //         if(t == null || t.next == null)
    //             return false;
    //         head = head.next;
    //         t = t.next.next;
    //     }
    //     return true;
    // }
}