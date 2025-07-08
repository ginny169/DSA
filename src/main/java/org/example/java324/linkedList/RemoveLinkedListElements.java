package org.example.java324.linkedList;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        head = removeElements(head, 1);

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //1263456
    //--> 6263456

    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;
        // 1 2 6 3 4 5 6, value = 1;

        while (current.next != null ) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return result.next;
    }

}
