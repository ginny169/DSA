package org.example.java324.linkedList;

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))));

        ListNode middle = middleNode2(head);

        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < size / 2; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 1 2 3 4 5 6
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
