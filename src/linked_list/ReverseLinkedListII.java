package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/7/14.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
//        ListNode node_0 = new ListNode(0);
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);

//        node_0.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

        ListNode result = reverseBetween(node_1, 3, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;

        if (m > n)
            return null;

        if (m == n)
            return head;

        ListNode t_head = head;

        ListNode last = head;
        int i = 1;
        while (i < n) {
            last = last.next;
            i++;
        }
        ListNode last_next = last.next;


        ListNode first = head;
        ListNode pre_first = null;
        int j = 1;
        while (j < m) {
            pre_first = first;
            first = first.next;
            j++;
        }

        int k = 1;
        ListNode prev = null, next;
        while (k <= n) {
            if (k > m) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            } else {
                prev = head;
                head = head.next;
            }
            k++;
        }

        if (pre_first != null) {
            pre_first.next = last;
        }

        first.next = last_next;

        return pre_first == null ? last : t_head;
    }
}
