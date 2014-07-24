package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/10/14.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        ListNode node_3 = new ListNode(2);
        ListNode node_4 = new ListNode(3);
        ListNode node_5 = new ListNode(4);
        ListNode node_6 = new ListNode(4);
        ListNode node_7 = new ListNode(5);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        node_6.next = node_7;

        ListNode result = swapPairs(node_1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode t_head = head.next;

        ListNode prev = head, cur = head.next;
        while (cur != null) {
            ListNode nxt;
            if (cur.next == null) {
                nxt = null;
            } else {
                nxt = cur.next.next == null ? cur.next : cur.next.next;
            }

            ListNode tmp = cur.next;

            cur.next = prev;
            prev.next = nxt;
            prev = tmp;
            cur = nxt;
        }

        return t_head;
    }
}
