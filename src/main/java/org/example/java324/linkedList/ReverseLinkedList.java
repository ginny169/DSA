package org.example.java324.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode cur = reverseList(head);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode result = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = result;
            result = current;
            current = temp;
        }
        return result;
    }
}
