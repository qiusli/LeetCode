package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/12/14.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
//        ListNode node_4 = new ListNode(4);
//        ListNode node_5 = new ListNode(5);
//        ListNode node_6 = new ListNode(6);
//        ListNode node_7 = new ListNode(7);

        node_1.next = node_2;
        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;
//        node_5.next = node_6;
//        node_6.next = node_7;

        ListNode result = reverseKGroup(node_1, 2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode r_head = head;

        int t_k = k;
        while (t_k - 1 > 0) {
            t_k--;
            head = head.next;

            if (head == null)
                return r_head;
        }
        ListNode t_head = head;
        head = r_head;

        ListNode prev = head, cur = head.next;
        while (true) {
            ListNode nxt_prev = null;

            // for one group
            int counter = k;
            prev.next = findNextKthNode(prev, k * 2 - 1) == null ?
                    findNextKthNode(prev, k) :
                    findNextKthNode(prev, k * 2 - 1);
            while (counter - 1 > 0) {
                counter--;

                ListNode nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;

                // update next prev & cur
                nxt_prev = cur;
            }

            if (hasNextKGroup(nxt_prev, k)) {
                prev = nxt_prev;
                cur = prev.next;
            } else {
                break;
            }
        }

        return t_head;
    }

    private static boolean hasNextKGroup(ListNode node, int k) {
        while (k > 0) {
            if (node == null)
                return false;

            node = node.next;
            k--;
        }

        return true;
    }

    private static ListNode findNextKthNode(ListNode node, int k) {
        while (k > 0) {
            k--;
            if (node == null)
                return null;

            node = node.next;
        }

        return node;
    }
}
