package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/9/14.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
//        ListNode node_2 = new ListNode(2);
//        ListNode node_3 = new ListNode(3);
//        ListNode node_4 = new ListNode(4);
//        ListNode node_5 = new ListNode(5);

//        node_1.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;

        ListNode result = rotateRight(node_1, 0);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode t_head = head;

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        n = n % len;

        head = t_head;

        int move_step = len - n - 1;

        ListNode pivot, r_head;
        while (move_step > 0) {
            head = head.next;
            move_step--;
        }

        pivot = head;
        r_head = head.next;

        while (head.next != null) {
            head = head.next;
        }
        head.next = t_head;

        pivot.next = null;

        return r_head == null ? t_head : r_head;
    }
}
