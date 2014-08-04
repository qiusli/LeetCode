package sorting;

import sorting.node.ListNode;

/**
 * Created by liqiushi on 8/3/14.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);

        l1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode l2 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(10);

        l2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // there's a node prior to the actual first node
        ListNode node = new ListNode(0);
        ListNode n = node;

        while (l1 != null && l2 != null) {
            int val;
            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(val);
            node = node.next;
        }

        while (l1 != null) {
            node.next = new ListNode(l1.val);
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            node.next = new ListNode(l2.val);
            node = node.next;
            l2 = l2.next;
        }

        return n.next;
    }
}
