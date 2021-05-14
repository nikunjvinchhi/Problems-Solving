package com.gtnexus.tms.rating.businesslogic;

public class PrintKthNode {
   static int c = 0;
   public static void main(String[] args) {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      printKthNode(head, 3);
      printKthNode(head, 2);
      printKthNode(head, 1);
      printKthNode(head, 4);
      printKthNode(head, 5);
   }
   static void printKthEle(Node head, int n) {
      if (head == null) {
         return;
      }
      printKthEle(head.next, n);
      if (n == ++c) {
         System.out.println(" = > " + head.data);
      }
   }
   static int printKthNode(Node head, int n) {
      if (head == null) {
         return 0;
      }
      int i = printKthNode(head.next, n);
      if(i+1 == n) {
         System.out.println(head.data);
      }

      return i+1;
   }
}
class Node {
   Node next;
   int data;
   Node() {
   }
   Node(int data) {
      this.data = data;
      this.next = null;
   }
}
