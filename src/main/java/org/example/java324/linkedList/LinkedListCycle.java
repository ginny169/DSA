package org.example.java324.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(-4);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;

        System.out.println(hasCycle(head1));
    }
    public static boolean hasCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null){
            if (set.contains(cur)){
                return true;
            }

            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
