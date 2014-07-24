package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/9/14.
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

        ListNode result = removeNthFromEnd(node_1, 4);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode t_head = head;
        while (head != null) {
            ListNode dis = head;
            int t_n = n;
            while (t_n > 0) {
                dis = dis.next;
                t_n--;
            }

            // find the one before the chosen digit
            if (dis == null) {
                head = head.next;
                t_head = head;
                break;
            }

            if (dis.next == null) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }

        return t_head;
    }
}
