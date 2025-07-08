package org.example.java324.linkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode result = mergeTwoLists(head, head2);
        ListNode cur = result;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-101);
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }
        return current.next;
    }
}
