package linkedlist;

import linkedlist.node.ListNode;

/**
 * Created by liqiushi on 7/8/14.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(4);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(2);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(2);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;

        ListNode result = partition(node_1, 3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode result = null;
        ListNode t_result = null;
        ListNode t_head = head;
        boolean head_set = false;

        while (t_head != null) {
            if (t_head.val < x) {
                if (!head_set) {
                    result = new ListNode(t_head.val);
                    t_result = result;
                    head_set = true;
                } else {
                    result.next = new ListNode(t_head.val);
                    result = result.next;
                }
            }
            t_head = t_head.next;
        }

        if (result == null)
            return head;

        t_head = head;
        while (t_head != null) {
            if (t_head.val >= x) {
                result.next = new ListNode(t_head.val);
                result = result.next;
            }

            t_head = t_head.next;
        }

        return t_result;
    }
}
