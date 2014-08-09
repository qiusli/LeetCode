package linkedlist;

import linkedlist.node.ListNode;

/**
 * Created by liqiushi on 7/8/14.
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        ListNode node_3 = new ListNode(2);
//        ListNode node_4 = new ListNode(3);
//        ListNode node_5 = new ListNode(4);
//        ListNode node_6 = new ListNode(4);
//        ListNode node_7 = new ListNode(5);

        node_1.next = node_2;
        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;
//        node_5.next = node_6;
//        node_6.next = node_7;

        ListNode result = deleteDuplicates(node_1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // find the pivot
        ListNode pivot = null;
        ListNode prev = null;
        while (head != null) {
            if (prev != null) {
                if (head.next != null) {
                    if (prev.val != head.val && head.val != head.next.val) {
                        pivot = head;
                        break;
                    }
                } else {
                    if (prev.val != head.val) {
                        pivot = head;
                        break;
                    }
                }
            } else {
                if (head.val != head.next.val) {
                    pivot = head;
                    break;
                }
            }

            if (head.next != null)
                prev = head;

            head = head.next;
        }

        if (pivot == null)
            return null;

        // start loop
        ListNode t_pivot = pivot;

        prev = pivot;
        ListNode new_start = pivot.next;
        while (new_start != null) {
            if (new_start.next != null) {
                if (prev.val != new_start.val && new_start.val != new_start.next.val) {
                    pivot.next = new_start;
                    pivot = new_start;
                }
            } else {
                if (prev.val != new_start.val) {
                    pivot.next = new_start;
                    pivot = new_start;
                }
            }

            if (new_start.next != null) {
                prev = new_start;
            }

            new_start = new_start.next;
            pivot.next = null;
        }

        return t_pivot;
    }
}
