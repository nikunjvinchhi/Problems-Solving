/**
Problem
160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode t = headA;
    //     int lenA = 0;
    //     while(t != null){
    //         lenA++;
    //         t = t.next;
    //     }
    //     t = headB;
    //     int lenB = 0;
    //     while(t != null){
    //         lenB++;
    //         t = t.next;
    //     }
    //     ListNode x;
    //     if(lenA > lenB){
    //         //System.out.println(lenA - lenB);
    //         t = headA;
    //         for(int i=0; i< (lenA-lenB); i++){
    //             t = t.next;
    //         }
    //         x = headB;
    //         //System.out.println(t.val);
    //     } else {
    //         t = headB;
    //         for(int i=0; i< (lenB-lenA); i++){
    //             t = t.next;
    //         }
    //         x = headA;
    //     }
    //     while(x != t){
    //         x = x.next;
    //         t = t.next;
    //     }
    //     return t;
    // }
    //reduce operation trying to use while.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t = headA;
        int lenA = 0;
        while(t != null){
            lenA++;
            t = t.next;
        }
        t = headB;
        int lenB = 0;
        while(t != null){
            lenB++;
            t = t.next;
        }
        ListNode x;
        
        if(lenA > lenB){
            x = headA;
            while(lenA-- != lenB){
                x = x.next;
            }
            t = headB;
        } else{
            x = headB;
            while(lenB-- != lenA){
                x = x.next;
            }
            t = headA;
        }
        while(x != t){
            x = x.next;
            t = t.next;
        }
        return t;
        
    }
}